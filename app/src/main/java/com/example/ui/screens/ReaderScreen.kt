package com.example.ui.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.models.Verse
import com.example.ui.BibleViewModel
import com.example.ui.components.AudioBar
import com.example.ui.components.BookSelectorSheet
import com.example.ui.components.NoteEditDialog
import com.example.ui.components.VerseActionSheet
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReaderScreen(
    viewModel: BibleViewModel
) {
    val currentBookName by viewModel.currentBookName.collectAsState()
    val currentChapter by viewModel.currentChapter.collectAsState()
    val verses by viewModel.currentVerses.collectAsState()
    val readerSettings by viewModel.readerSettings.collectAsState()
    val selectedVerse by viewModel.selectedVerse.collectAsState()

    val isTtsPlaying by viewModel.ttsHelper.isPlaying.collectAsState()
    val ttsVerseIndex by viewModel.ttsHelper.currentVerseIndex.collectAsState()

    var showBookSelector by remember { mutableStateOf(false) }
    var showFontSettingsMenu by remember { mutableStateOf(false) }
    var noteDialogVerse by remember { mutableStateOf<Verse?>(null) }

    val listState = rememberLazyListState()

    // Determine font family
    val selectedFontFamily = when (readerSettings.fontFamilyType) {
        "sans" -> BibleSansFontFamily
        "mono" -> BibleMonospaceFontFamily
        else -> BibleSerifFontFamily
    }

    // Determine Theme background
    val readerBgColor = when (readerSettings.readerTheme) {
        "white" -> Color.White
        "sepia" -> SoftSepia
        "dark" -> ObsidianBackground
        else -> ParchmentBackground
    }

    val readerTextColor = when (readerSettings.readerTheme) {
        "dark" -> WarmIvoryText
        "sepia" -> Color(0xFF3E2723)
        else -> MahoganyText
    }

    // Book Navigation
    val bookObj = viewModel.getBookByName(currentBookName)
    val maxChapters = bookObj?.totalChapters ?: 1

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Surface(
                        onClick = { showBookSelector = true },
                        shape = RoundedCornerShape(20.dp),
                        color = MaterialTheme.colorScheme.primaryContainer,
                        modifier = Modifier.testTag("reader_book_chapter_selector")
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                        ) {
                            Text(
                                text = "$currentBookName $currentChapter",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "Select Book Chapter",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                },
                actions = {
                    // Audio TTS Chapter Button
                    IconButton(
                        onClick = {
                            if (isTtsPlaying) viewModel.stopAudioChapter() else viewModel.playAudioChapter()
                        },
                        modifier = Modifier.testTag("reader_play_audio_btn")
                    ) {
                        Icon(
                            imageVector = if (isTtsPlaying) Icons.Filled.VolumeUp else Icons.Outlined.VolumeUp,
                            contentDescription = "Read Chapter Aloud",
                            tint = if (isTtsPlaying) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                        )
                    }

                    // Reader Font & Theme Settings Menu
                    Box {
                        IconButton(
                            onClick = { showFontSettingsMenu = true },
                            modifier = Modifier.testTag("reader_font_settings_btn")
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.FormatSize,
                                contentDescription = "Text Settings"
                            )
                        }

                        DropdownMenu(
                            expanded = showFontSettingsMenu,
                            onDismissRequest = { showFontSettingsMenu = false },
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .width(260.dp)
                                    .padding(8.dp),
                                verticalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                Text("Font Size", style = MaterialTheme.typography.labelLarge)
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    IconButton(
                                        onClick = { viewModel.updateReaderSettings(fontSize = (readerSettings.fontSizeSp - 2).coerceAtLeast(14)) }
                                    ) {
                                        Text("A-", fontWeight = FontWeight.Bold)
                                    }
                                    Text("${readerSettings.fontSizeSp} sp", style = MaterialTheme.typography.titleMedium)
                                    IconButton(
                                        onClick = { viewModel.updateReaderSettings(fontSize = (readerSettings.fontSizeSp + 2).coerceAtMost(28)) }
                                    ) {
                                        Text("A+", fontWeight = FontWeight.Bold)
                                    }
                                }

                                HorizontalDivider()

                                Text("Font Style", style = MaterialTheme.typography.labelLarge)
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    FilterChip(
                                        selected = readerSettings.fontFamilyType == "serif",
                                        onClick = { viewModel.updateReaderSettings(fontFamily = "serif") },
                                        label = { Text("Serif") }
                                    )
                                    FilterChip(
                                        selected = readerSettings.fontFamilyType == "sans",
                                        onClick = { viewModel.updateReaderSettings(fontFamily = "sans") },
                                        label = { Text("Sans") }
                                    )
                                    FilterChip(
                                        selected = readerSettings.fontFamilyType == "mono",
                                        onClick = { viewModel.updateReaderSettings(fontFamily = "mono") },
                                        label = { Text("Mono") }
                                    )
                                }

                                HorizontalDivider()

                                Text("Reader Theme", style = MaterialTheme.typography.labelLarge)
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(36.dp)
                                            .clip(CircleShape)
                                            .background(ParchmentBackground)
                                            .clickable { viewModel.updateReaderSettings(theme = "parchment") },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        if (readerSettings.readerTheme == "parchment") Icon(Icons.Default.Check, "Parchment", tint = MahoganyText)
                                    }
                                    Box(
                                        modifier = Modifier
                                            .size(36.dp)
                                            .clip(CircleShape)
                                            .background(Color.White)
                                            .clickable { viewModel.updateReaderSettings(theme = "white") },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        if (readerSettings.readerTheme == "white") Icon(Icons.Default.Check, "White", tint = Color.Black)
                                    }
                                    Box(
                                        modifier = Modifier
                                            .size(36.dp)
                                            .clip(CircleShape)
                                            .background(SoftSepia)
                                            .clickable { viewModel.updateReaderSettings(theme = "sepia") },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        if (readerSettings.readerTheme == "sepia") Icon(Icons.Default.Check, "Sepia", tint = Color(0xFF3E2723))
                                    }
                                    Box(
                                        modifier = Modifier
                                            .size(36.dp)
                                            .clip(CircleShape)
                                            .background(ObsidianBackground)
                                            .clickable { viewModel.updateReaderSettings(theme = "dark") },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        if (readerSettings.readerTheme == "dark") Icon(Icons.Default.Check, "Dark", tint = WarmIvoryText)
                                    }
                                }
                            }
                        }
                    }
                }
            )
        },
        bottomBar = {
            Column {
                // Audio TTS Bar
                AudioBar(
                    isPlaying = isTtsPlaying,
                    currentVerseIndex = ttsVerseIndex,
                    bookName = currentBookName,
                    chapter = currentChapter,
                    onPause = { viewModel.pauseAudioChapter() },
                    onResume = { viewModel.playAudioChapter() },
                    onStop = { viewModel.stopAudioChapter() }
                )

                // Chapter Prev / Next Navigator Bar
                Surface(
                    color = MaterialTheme.colorScheme.surface,
                    tonalElevation = 4.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextButton(
                            enabled = currentChapter > 1,
                            onClick = { viewModel.loadChapter(currentBookName, currentChapter - 1) },
                            modifier = Modifier.testTag("reader_prev_chapter_btn")
                        ) {
                            Icon(Icons.Default.ChevronLeft, "Previous Chapter")
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Prev Ch")
                        }

                        Text(
                            text = "Chapter $currentChapter of $maxChapters",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        TextButton(
                            enabled = currentChapter < maxChapters,
                            onClick = { viewModel.loadChapter(currentBookName, currentChapter + 1) },
                            modifier = Modifier.testTag("reader_next_chapter_btn")
                        ) {
                            Text("Next Ch")
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(Icons.Default.ChevronRight, "Next Chapter")
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(readerBgColor)
        ) {
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),
                contentPadding = PaddingValues(top = 16.dp, bottom = 40.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                // Book & Chapter Header Banner
                item {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp)
                    ) {
                        Text(
                            text = currentBookName.uppercase(),
                            style = MaterialTheme.typography.labelLarge,
                            letterSpacing = 2.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Chapter $currentChapter",
                            style = MaterialTheme.typography.displayLarge,
                            fontFamily = selectedFontFamily,
                            fontWeight = FontWeight.Bold,
                            color = readerTextColor
                        )
                        HorizontalDivider(
                            modifier = Modifier
                                .width(60.dp)
                                .padding(top = 8.dp),
                            color = MaterialTheme.colorScheme.primary,
                            thickness = 2.dp
                        )
                    }
                }

                // Chapter Verses
                items(verses, key = { it.verseNumber }) { verse ->
                    val isTtsActiveVerse = ttsVerseIndex == (verse.verseNumber - 1)

                    val highlightBgColor = when (verse.highlightColorHex) {
                        "#FFF176" -> HighlightYellow.copy(alpha = 0.35f)
                        "#80DEEA" -> HighlightCyan.copy(alpha = 0.35f)
                        "#F8BBD0" -> HighlightPink.copy(alpha = 0.35f)
                        "#FFE082" -> HighlightAmber.copy(alpha = 0.35f)
                        "#E1BEE7" -> HighlightPurple.copy(alpha = 0.35f)
                        else -> if (isTtsActiveVerse) MaterialTheme.colorScheme.primaryContainer else Color.Transparent
                    }

                    Surface(
                        color = highlightBgColor,
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { viewModel.selectVerse(verse) }
                            .testTag("verse_item_${verse.verseNumber}")
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.Top
                        ) {
                            // Verse Number Badge
                            Text(
                                text = "${verse.verseNumber}",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontSize = (readerSettings.fontSizeSp - 3).sp
                                ),
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary,
                                modifier = Modifier
                                    .padding(end = 12.dp, top = 2.dp)
                                    .widthIn(min = 20.dp)
                            )

                            // Verse Text
                            Text(
                                text = verse.text,
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontSize = readerSettings.fontSizeSp.sp,
                                    lineHeight = (readerSettings.fontSizeSp * 1.55).sp
                                ),
                                fontFamily = selectedFontFamily,
                                color = readerTextColor,
                                modifier = Modifier.weight(1f)
                            )

                            // Indicators for Bookmark and Note
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(4.dp),
                                modifier = Modifier.padding(start = 6.dp)
                            ) {
                                if (verse.isBookmarked) {
                                    Icon(
                                        imageVector = Icons.Filled.Bookmark,
                                        contentDescription = "Bookmarked",
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                                if (verse.hasNote) {
                                    Icon(
                                        imageVector = Icons.Filled.EditNote,
                                        contentDescription = "Has Reflection Note",
                                        tint = MaterialTheme.colorScheme.secondary,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // Modal Book & Chapter Selector
    if (showBookSelector) {
        BookSelectorSheet(
            allBooks = viewModel.getAllBooks(),
            currentBookName = currentBookName,
            currentChapter = currentChapter,
            onDismiss = { showBookSelector = false },
            onSelectBookChapter = { book, ch ->
                viewModel.loadChapter(book, ch)
            }
        )
    }

    // Verse Actions Sheet
    if (selectedVerse != null) {
        VerseActionSheet(
            verse = selectedVerse!!,
            onDismiss = { viewModel.selectVerse(null) },
            onToggleBookmark = { viewModel.toggleBookmark(it) },
            onSetHighlight = { v, color -> viewModel.setHighlight(v, color) },
            onRemoveHighlight = { viewModel.removeHighlight(it) },
            onAddNoteRequested = { noteDialogVerse = it },
            onListenVerseRequested = { v ->
                viewModel.ttsHelper.speakChapter(listOf(v.verseNumber to v.text))
            }
        )
    }

    // Note Reflection Dialog
    if (noteDialogVerse != null) {
        NoteEditDialog(
            verse = noteDialogVerse!!,
            onDismiss = { noteDialogVerse = null },
            onSaveNote = { title, content ->
                viewModel.saveNote(noteDialogVerse!!, title, content)
            }
        )
    }
}
