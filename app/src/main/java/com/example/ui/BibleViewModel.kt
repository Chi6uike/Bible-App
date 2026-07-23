package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.BibleDatabase
import com.example.data.local.BookmarkEntity
import com.example.data.local.HighlightEntity
import com.example.data.local.NoteEntity
import com.example.data.local.RecentReadingEntity
import com.example.data.models.*
import com.example.data.repository.BibleRepository
import com.example.util.TextToSpeechHelper
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class ReaderSettings(
    val fontSizeSp: Int = 18,
    val fontFamilyType: String = "serif", // "serif", "sans", "mono"
    val readerTheme: String = "parchment" // "parchment", "white", "sepia", "dark"
)

class BibleViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: BibleRepository
    val ttsHelper: TextToSpeechHelper

    init {
        val db = BibleDatabase.getDatabase(application)
        repository = BibleRepository(db.bibleDao())
        ttsHelper = TextToSpeechHelper(application)
    }

    // Reader State
    private val _currentBookName = MutableStateFlow("Psalms")
    val currentBookName: StateFlow<String> = _currentBookName

    private val _currentChapter = MutableStateFlow(23)
    val currentChapter: StateFlow<Int> = _currentChapter

    private val _currentVerses = MutableStateFlow<List<Verse>>(emptyList())
    val currentVerses: StateFlow<List<Verse>> = _currentVerses

    private val _selectedVerse = MutableStateFlow<Verse?>(null)
    val selectedVerse: StateFlow<Verse?> = _selectedVerse

    private val _readerSettings = MutableStateFlow(ReaderSettings())
    val readerSettings: StateFlow<ReaderSettings> = _readerSettings

    // Saved Data Flow
    val bookmarks: StateFlow<List<BookmarkEntity>> = repository.allBookmarks
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val highlights: StateFlow<List<HighlightEntity>> = repository.allHighlights
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val notes: StateFlow<List<NoteEntity>> = repository.allNotes
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val recentReading: StateFlow<RecentReadingEntity?> = repository.recentReading
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    // Search State
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _searchTestament = MutableStateFlow<Testament?>(null)
    val searchTestament: StateFlow<Testament?> = _searchTestament

    private val _searchResults = MutableStateFlow<List<Verse>>(emptyList())
    val searchResults: StateFlow<List<Verse>> = _searchResults

    // Reading Plan Active Tab / Selected Plan
    private val _selectedPlan = MutableStateFlow<ReadingPlan?>(null)
    val selectedPlan: StateFlow<ReadingPlan?> = _selectedPlan

    init {
        loadChapter("Psalms", 23)
    }

    fun loadChapter(bookName: String, chapter: Int) {
        viewModelScope.launch {
            _currentBookName.value = bookName
            _currentChapter.value = chapter
            _selectedVerse.value = null

            val verses = repository.getVersesForChapter(bookName, chapter)
            _currentVerses.value = verses

            repository.saveRecentReading(bookName, chapter)
        }
    }

    fun selectVerse(verse: Verse?) {
        _selectedVerse.value = verse
    }

    fun toggleBookmark(verse: Verse) {
        viewModelScope.launch {
            repository.toggleBookmark(
                bookName = verse.bookName,
                chapter = verse.chapter,
                verseNumber = verse.verseNumber,
                verseText = verse.text
            )
            loadChapter(_currentBookName.value, _currentChapter.value)
        }
    }

    fun setHighlight(verse: Verse, colorHex: String) {
        viewModelScope.launch {
            repository.setHighlight(verse.bookName, verse.chapter, verse.verseNumber, colorHex)
            loadChapter(_currentBookName.value, _currentChapter.value)
        }
    }

    fun removeHighlight(verse: Verse) {
        viewModelScope.launch {
            repository.removeHighlight(verse.bookName, verse.chapter, verse.verseNumber)
            loadChapter(_currentBookName.value, _currentChapter.value)
        }
    }

    fun saveNote(verse: Verse, title: String, content: String) {
        viewModelScope.launch {
            repository.saveNote(verse.bookName, verse.chapter, verse.verseNumber, title, content)
            loadChapter(_currentBookName.value, _currentChapter.value)
        }
    }

    fun deleteNote(id: Long) {
        viewModelScope.launch {
            repository.deleteNote(id)
        }
    }

    fun updateReaderSettings(fontSize: Int? = null, fontFamily: String? = null, theme: String? = null) {
        _readerSettings.value = _readerSettings.value.copy(
            fontSizeSp = fontSize ?: _readerSettings.value.fontSizeSp,
            fontFamilyType = fontFamily ?: _readerSettings.value.fontFamilyType,
            readerTheme = theme ?: _readerSettings.value.readerTheme
        )
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
        performSearch()
    }

    fun setSearchTestamentFilter(testament: Testament?) {
        _searchTestament.value = testament
        performSearch()
    }

    private fun performSearch() {
        viewModelScope.launch {
            _searchResults.value = repository.searchVerses(
                query = _searchQuery.value,
                testamentFilter = _searchTestament.value
            )
        }
    }

    fun playAudioChapter() {
        val verses = _currentVerses.value.map { it.verseNumber to it.text }
        ttsHelper.speakChapter(verses)
    }

    fun pauseAudioChapter() {
        ttsHelper.pause()
    }

    fun stopAudioChapter() {
        ttsHelper.stop()
    }

    fun selectPlan(plan: ReadingPlan?) {
        _selectedPlan.value = plan
    }

    fun getPlanProgress(planId: String): Flow<Map<String, Boolean>> {
        return repository.getPlanProgress(planId)
    }

    fun togglePlanReading(planId: String, dayNumber: Int, readingIndex: Int, isCompleted: Boolean) {
        viewModelScope.launch {
            repository.togglePlanReading(planId, dayNumber, readingIndex, isCompleted)
        }
    }

    fun getAllBooks(): List<Book> = repository.getAllBooks()

    fun getBookByName(name: String): Book? = repository.getBookByName(name)

    override fun onCleared() {
        super.onCleared()
        ttsHelper.shutdown()
    }
}
