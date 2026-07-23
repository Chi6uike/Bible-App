package com.example.data.repository

import com.example.data.bible_data.BibleData
import com.example.data.local.*
import com.example.data.models.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class BibleRepository(private val bibleDao: BibleDao) {

    fun getAllBooks(): List<Book> = BibleData.BOOKS

    fun getBookByName(name: String): Book? {
        return BibleData.BOOKS.find { it.name.equals(name, ignoreCase = true) }
    }

    suspend fun getVersesForChapter(bookName: String, chapter: Int): List<Verse> {
        val baseVerses = BibleData.getVersesForChapter(bookName, chapter)

        // Fetch highlights and notes from DB
        val chapterHighlights = bibleDao.getHighlightsForChapter(bookName, chapter).firstOrNull() ?: emptyList()
        val chapterNotes = bibleDao.getNotesForChapter(bookName, chapter).firstOrNull() ?: emptyList()

        val highlightMap = chapterHighlights.associateBy { it.verseNumber }
        val noteSet = chapterNotes.map { it.verseNumber }.toSet()

        return baseVerses.map { verse ->
            val bookmark = bibleDao.getBookmark(bookName, chapter, verse.verseNumber)
            val highlight = highlightMap[verse.verseNumber]
            val hasNote = noteSet.contains(verse.verseNumber)

            verse.copy(
                isBookmarked = bookmark != null,
                highlightColorHex = highlight?.colorHex,
                hasNote = hasNote
            )
        }
    }

    fun searchVerses(query: String, testamentFilter: Testament? = null, bookFilter: String? = null): List<Verse> {
        if (query.trim().isBlank()) return emptyList()
        val lowerQuery = query.trim().lowercase()

        val results = mutableListOf<Verse>()

        // Search through books
        val targetBooks = BibleData.BOOKS.filter { book ->
            (testamentFilter == null || book.testament == testamentFilter) &&
            (bookFilter == null || book.name.equals(bookFilter, ignoreCase = true))
        }

        for (book in targetBooks) {
            // Search first 5 chapters or total chapters for matches
            val chaptersToSearch = minOf(book.totalChapters, 10)
            for (ch in 1..chaptersToSearch) {
                val verses = BibleData.getVersesForChapter(book.name, ch)
                for (v in verses) {
                    if (v.text.lowercase().contains(lowerQuery) || "${book.name} ${v.chapter}:${v.verseNumber}".lowercase().contains(lowerQuery)) {
                        results.add(v)
                        if (results.size >= 50) return results
                    }
                }
            }
        }
        return results
    }

    // Bookmark operations
    val allBookmarks: Flow<List<BookmarkEntity>> = bibleDao.getAllBookmarks()

    suspend fun toggleBookmark(bookName: String, chapter: Int, verseNumber: Int, verseText: String): Boolean {
        val existing = bibleDao.getBookmark(bookName, chapter, verseNumber)
        return if (existing != null) {
            bibleDao.deleteBookmark(bookName, chapter, verseNumber)
            false
        } else {
            bibleDao.insertBookmark(
                BookmarkEntity(
                    bookName = bookName,
                    chapter = chapter,
                    verseNumber = verseNumber,
                    verseText = verseText
                )
            )
            true
        }
    }

    // Highlight operations
    val allHighlights: Flow<List<HighlightEntity>> = bibleDao.getAllHighlights()

    suspend fun setHighlight(bookName: String, chapter: Int, verseNumber: Int, colorHex: String) {
        bibleDao.insertHighlight(
            HighlightEntity(
                bookName = bookName,
                chapter = chapter,
                verseNumber = verseNumber,
                colorHex = colorHex
            )
        )
    }

    suspend fun removeHighlight(bookName: String, chapter: Int, verseNumber: Int) {
        bibleDao.deleteHighlight(bookName, chapter, verseNumber)
    }

    // Note operations
    val allNotes: Flow<List<NoteEntity>> = bibleDao.getAllNotes()

    suspend fun saveNote(bookName: String, chapter: Int, verseNumber: Int, title: String, content: String) {
        bibleDao.insertNote(
            NoteEntity(
                bookName = bookName,
                chapter = chapter,
                verseNumber = verseNumber,
                title = title,
                content = content
            )
        )
    }

    suspend fun deleteNote(id: Long) {
        bibleDao.deleteNote(id)
    }

    // Plan Progress
    fun getPlanProgress(planId: String): Flow<Map<String, Boolean>> {
        return bibleDao.getPlanProgress(planId).map { list ->
            list.associate { it.key to it.isCompleted }
        }
    }

    suspend fun togglePlanReading(planId: String, dayNumber: Int, readingIndex: Int, isCompleted: Boolean) {
        val key = "${planId}_${dayNumber}_$readingIndex"
        bibleDao.setPlanProgress(
            PlanProgressEntity(
                key = key,
                planId = planId,
                dayNumber = dayNumber,
                isCompleted = isCompleted
            )
        )
    }

    // Recent Reading
    val recentReading: Flow<RecentReadingEntity?> = bibleDao.getRecentReading()

    suspend fun saveRecentReading(bookName: String, chapter: Int, verseNumber: Int = 1) {
        bibleDao.saveRecentReading(
            RecentReadingEntity(
                bookName = bookName,
                chapter = chapter,
                verseNumber = verseNumber
            )
        )
    }
}
