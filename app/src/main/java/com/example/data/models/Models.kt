package com.example.data.models

enum class Testament {
    OLD_TESTAMENT,
    NEW_TESTAMENT
}

enum class BookCategory(val displayName: String) {
    LAW("Pentateuch / Law"),
    HISTORY("Historical Books"),
    WISDOM("Poetry & Wisdom"),
    MAJOR_PROPHETS("Major Prophets"),
    MINOR_PROPHETS("Minor Prophets"),
    GOSPELS("The Gospels"),
    CHURCH_HISTORY("Church History"),
    EPISTLES("Epistles & Letters"),
    PROPHECY("Prophecy")
}

data class Book(
    val id: Int,
    val name: String,
    val abbreviation: String,
    val testament: Testament,
    val category: BookCategory,
    val totalChapters: Int,
    val summary: String = ""
)

data class Verse(
    val bookName: String,
    val chapter: Int,
    val verseNumber: Int,
    val text: String,
    var isBookmarked: Boolean = false,
    var highlightColorHex: String? = null,
    var hasNote: Boolean = false
)

data class Devotional(
    val id: String,
    val date: String,
    val title: String,
    val verseReference: String,
    val verseText: String,
    val reflection: String,
    val prayer: String,
    val author: String = "Daily Bread"
)

data class TopicCategory(
    val name: String,
    val iconName: String,
    val verses: List<TopicVerse>
)

data class TopicVerse(
    val reference: String,
    val text: String,
    val bookName: String,
    val chapter: Int,
    val verseNumber: Int
)

data class ReadingPlan(
    val id: String,
    val title: String,
    val description: String,
    val totalDays: Int,
    val category: String,
    val days: List<ReadingPlanDay>
)

data class ReadingPlanDay(
    val dayNumber: Int,
    val title: String,
    val readings: List<PlanReading>
)

data class PlanReading(
    val bookName: String,
    val chapter: Int,
    val displayReference: String
)
