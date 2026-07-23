package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ui.BibleViewModel
import com.example.ui.theme.*

@Composable
fun SettingsScreen(
    viewModel: BibleViewModel
) {
    val readerSettings by viewModel.readerSettings.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "App Settings",
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        // Scripture Reader Preferences
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Text(
                    text = "Reader Preferences",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                // Font Size Slider
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Font Size", style = MaterialTheme.typography.titleMedium)
                        Text("${readerSettings.fontSizeSp} sp", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    }

                    Slider(
                        value = readerSettings.fontSizeSp.toFloat(),
                        onValueChange = { viewModel.updateReaderSettings(fontSize = it.toInt()) },
                        valueRange = 14f..28f,
                        steps = 6,
                        modifier = Modifier.testTag("settings_font_slider")
                    )
                }

                HorizontalDivider()

                // Font Style
                Text("Font Family", style = MaterialTheme.typography.titleMedium)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    FilterChip(
                        selected = readerSettings.fontFamilyType == "serif",
                        onClick = { viewModel.updateReaderSettings(fontFamily = "serif") },
                        label = { Text("Classic Serif") }
                    )
                    FilterChip(
                        selected = readerSettings.fontFamilyType == "sans",
                        onClick = { viewModel.updateReaderSettings(fontFamily = "sans") },
                        label = { Text("Modern Sans") }
                    )
                    FilterChip(
                        selected = readerSettings.fontFamilyType == "mono",
                        onClick = { viewModel.updateReaderSettings(fontFamily = "mono") },
                        label = { Text("Monospace") }
                    )
                }

                HorizontalDivider()

                // Theme Palette
                Text("Default Canvas Theme", style = MaterialTheme.typography.titleMedium)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    ThemeOptionBox("Parchment", ParchmentBackground, MahoganyText, readerSettings.readerTheme == "parchment") {
                        viewModel.updateReaderSettings(theme = "parchment")
                    }
                    ThemeOptionBox("White", Color.White, Color.Black, readerSettings.readerTheme == "white") {
                        viewModel.updateReaderSettings(theme = "white")
                    }
                    ThemeOptionBox("Sepia", SoftSepia, Color(0xFF3E2723), readerSettings.readerTheme == "sepia") {
                        viewModel.updateReaderSettings(theme = "sepia")
                    }
                    ThemeOptionBox("Dark", ObsidianBackground, WarmIvoryText, readerSettings.readerTheme == "dark") {
                        viewModel.updateReaderSettings(theme = "dark")
                    }
                }
            }
        }

        // About & Translation Info
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Offline Scripture Data",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                Text(
                    text = "• Translation: World English Bible (WEB)\n• Offline Availability: 100% Offline (66 Books / 1,189 Chapters)\n• Audio: Built-in Text-To-Speech (TTS)\n• Persistence: Room SQLite Local Storage",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        // App Information
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = "Holy Bible App v1.0",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Crafted with Jetpack Compose & Kotlin.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(modifier = Modifier.height(100.dp))
    }
}

@Composable
fun ThemeOptionBox(
    name: String,
    bgColor: Color,
    textColor: Color,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
                .background(bgColor)
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            if (isSelected) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = name,
                    tint = textColor
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(name, style = MaterialTheme.typography.labelSmall)
    }
}
