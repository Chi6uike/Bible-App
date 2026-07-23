package com.example.util

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.*

class TextToSpeechHelper(context: Context) : TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = TextToSpeech(context.applicationContext, this)
    private var isInitialized = false

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying: StateFlow<Boolean> = _isPlaying

    private val _currentVerseIndex = MutableStateFlow(-1)
    val currentVerseIndex: StateFlow<Int> = _currentVerseIndex

    private var speechQueue: List<Pair<Int, String>> = emptyList()
    private var queueIndex = 0

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts?.setLanguage(Locale.US)
            if (result != TextToSpeech.LANG_MISSING_DATA && result != TextToSpeech.LANG_NOT_SUPPORTED) {
                isInitialized = true
                setupUtteranceListener()
            }
        }
    }

    private fun setupUtteranceListener() {
        tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
            override fun onStart(utteranceId: String?) {
                utteranceId?.toIntOrNull()?.let { index ->
                    _currentVerseIndex.value = index
                }
                _isPlaying.value = true
            }

            override fun onDone(utteranceId: String?) {
                queueIndex++
                if (queueIndex < speechQueue.size) {
                    speakCurrentQueueItem()
                } else {
                    _isPlaying.value = false
                    _currentVerseIndex.value = -1
                }
            }

            override fun onError(utteranceId: String?) {
                _isPlaying.value = false
                _currentVerseIndex.value = -1
            }
        })
    }

    fun speakChapter(verses: List<Pair<Int, String>>, pitch: Float = 1.0f, rate: Float = 0.95f) {
        if (!isInitialized) return
        stop()

        speechQueue = verses
        queueIndex = 0
        tts?.setPitch(pitch)
        tts?.setSpeechRate(rate)

        if (speechQueue.isNotEmpty()) {
            speakCurrentQueueItem()
        }
    }

    private fun speakCurrentQueueItem() {
        if (queueIndex in speechQueue.indices) {
            val (verseNum, text) = speechQueue[queueIndex]
            val params = android.os.Bundle()
            params.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, queueIndex.toString())
            tts?.speak("Verse $verseNum. $text", TextToSpeech.QUEUE_FLUSH, params, queueIndex.toString())
        }
    }

    fun pause() {
        tts?.stop()
        _isPlaying.value = false
    }

    fun resume() {
        if (queueIndex in speechQueue.indices) {
            speakCurrentQueueItem()
        }
    }

    fun stop() {
        tts?.stop()
        _isPlaying.value = false
        _currentVerseIndex.value = -1
        speechQueue = emptyList()
        queueIndex = 0
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
    }
}
