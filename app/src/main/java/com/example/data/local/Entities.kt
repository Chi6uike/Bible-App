package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarks")
data class BookmarkEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val bookName: String,
    val chapter: Int,
    val verseNumber: Int,
    val verseText: String,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "highlights")
data class HighlightEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val bookName: String,
    val chapter: Int,
    val verseNumber: Int,
    val colorHex: String, // e.g. "#FFF59D", "#A5D6A7", "#FFCC80", "#E1BEE7", "#80DEEA"
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val bookName: String,
    val chapter: Int,
    val verseNumber: Int,
    val title: String,
    val content: String,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "plan_progress")
data class PlanProgressEntity(
    @PrimaryKey val key: String, // e.g. "plan_id_day_readingIndex"
    val planId: String,
    val dayNumber: Int,
    val isCompleted: Boolean,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "recent_readings")
data class RecentReadingEntity(
    @PrimaryKey val id: String = "last_read",
    val bookName: String,
    val chapter: Int,
    val verseNumber: Int = 1,
    val timestamp: Long = System.currentTimeMillis()
)
