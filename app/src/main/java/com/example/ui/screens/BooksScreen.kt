package com.example.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.models.Book
import com.example.data.models.BookCategory
import com.example.data.models.Testament
import com.example.ui.BibleViewModel
import com.example.ui.components.BookSelectorSheet

@Composable
fun BooksScreen(
    viewModel: BibleViewModel,
    onNavigateToReader: (String, Int) -> Unit
) {
    val allBooks = viewModel.getAllBooks()
    var selectedTestament by remember { mutableStateOf<Testament?>(null) }
    var selectedCategory by remember { mutableStateOf<BookCategory?>(null) }
    var selectedBookForChapters by remember { mutableStateOf<Book?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
    ) {
        Text(
            text = "Scripture Books",
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        // Testament Segmented Filter
        SingleChoiceSegmentedButtonRow(modifier = Modifier.fillMaxWidth()) {
            SegmentedButton(
                selected = selectedTestament == null,
                onClick = { selectedTestament = null },
                shape = SegmentedButtonDefaults.itemShape(index = 0, count = 3)
            ) {
                Text("All (66)")
            }
            SegmentedButton(
                selected = selectedTestament == Testament.OLD_TESTAMENT,
                onClick = { selectedTestament = Testament.OLD_TESTAMENT },
                shape = SegmentedButtonDefaults.itemShape(index = 1, count = 3)
            ) {
                Text("Old Testament (39)")
            }
            SegmentedButton(
                selected = selectedTestament == Testament.NEW_TESTAMENT,
                onClick = { selectedTestament = Testament.NEW_TESTAMENT },
                shape = SegmentedButtonDefaults.itemShape(index = 2, count = 3)
            ) {
                Text("New Testament (27)")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Category Filter Chips
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            item {
                FilterChip(
                    selected = selectedCategory == null,
                    onClick = { selectedCategory = null },
                    label = { Text("All Categories") }
                )
            }
            items(BookCategory.values()) { category ->
                FilterChip(
                    selected = selectedCategory == category,
                    onClick = {
                        selectedCategory = if (selectedCategory == category) null else category
                    },
                    label = { Text(category.displayName) }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Books Grid List
        val filteredBooks = allBooks.filter { book ->
            (selectedTestament == null || book.testament == selectedTestament) &&
            (selectedCategory == null || book.category == selectedCategory)
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(bottom = 100.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(filteredBooks, key = { it.id }) { book ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { selectedBookForChapters = book }
                        .testTag("book_card_${book.name}")
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = book.name,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Surface(
                                color = MaterialTheme.colorScheme.primaryContainer,
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Text(
                                    text = "${book.totalChapters} Ch",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                )
                            }
                        }

                        Text(
                            text = book.category.displayName,
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.secondary
                        )

                        Text(
                            text = book.summary,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 2
                        )
                    }
                }
            }
        }
    }

    // Modal Chapter Picker when book clicked
    if (selectedBookForChapters != null) {
        val book = selectedBookForChapters!!
        BookSelectorSheet(
            allBooks = allBooks,
            currentBookName = book.name,
            currentChapter = 1,
            onDismiss = { selectedBookForChapters = null },
            onSelectBookChapter = { selectedBookName, chapter ->
                onNavigateToReader(selectedBookName, chapter)
            }
        )
    }
}
