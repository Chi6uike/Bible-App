package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BibleDao {
    // Bookmarks
    @Query("SELECT * FROM bookmarks ORDER BY timestamp DESC")
    fun getAllBookmarks(): Flow<List<BookmarkEntity>>

    @Query("SELECT * FROM bookmarks WHERE bookName = :bookName AND chapter = :chapter AND verseNumber = :verseNumber LIMIT 1")
    suspend fun getBookmark(bookName: String, chapter: Int, verseNumber: Int): BookmarkEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookmark(bookmark: BookmarkEntity)

    @Query("DELETE FROM bookmarks WHERE bookName = :bookName AND chapter = :chapter AND verseNumber = :verseNumber")
    suspend fun deleteBookmark(bookName: String, chapter: Int, verseNumber: Int)

    // Highlights
    @Query("SELECT * FROM highlights WHERE bookName = :bookName AND chapter = :chapter")
    fun getHighlightsForChapter(bookName: String, chapter: Int): Flow<List<HighlightEntity>>

    @Query("SELECT * FROM highlights ORDER BY timestamp DESC")
    fun getAllHighlights(): Flow<List<HighlightEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHighlight(highlight: HighlightEntity)

    @Query("DELETE FROM highlights WHERE bookName = :bookName AND chapter = :chapter AND verseNumber = :verseNumber")
    suspend fun deleteHighlight(bookName: String, chapter: Int, verseNumber: Int)

    // Notes
    @Query("SELECT * FROM notes WHERE bookName = :bookName AND chapter = :chapter")
    fun getNotesForChapter(bookName: String, chapter: Int): Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes ORDER BY timestamp DESC")
    fun getAllNotes(): Flow<List<NoteEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)

    @Query("DELETE FROM notes WHERE id = :id")
    suspend fun deleteNote(id: Long)

    // Reading Plan Progress
    @Query("SELECT * FROM plan_progress WHERE planId = :planId")
    fun getPlanProgress(planId: String): Flow<List<PlanProgressEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setPlanProgress(progress: PlanProgressEntity)

    // Recent Reading
    @Query("SELECT * FROM recent_readings WHERE id = 'last_read'")
    fun getRecentReading(): Flow<RecentReadingEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRecentReading(reading: RecentReadingEntity)
}
