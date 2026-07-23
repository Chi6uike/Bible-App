package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ui.BibleViewModel
import com.example.ui.components.BibleBottomBar
import com.example.ui.navigation.NavRoutes
import com.example.ui.screens.*
import com.example.ui.theme.BibleAppTheme

class MainActivity : ComponentActivity() {

    private val viewModel: BibleViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            BibleAppTheme {
                var currentRoute by remember { mutableStateOf(NavRoutes.Home.route) }
                var initialSearchTopic by remember { mutableStateOf<String?>(null) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        if (currentRoute != NavRoutes.Reader.route) {
                            TopAppBar(
                                title = {
                                    Row(
                                        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.MenuBook,
                                            contentDescription = "Bible Logo",
                                            tint = MaterialTheme.colorScheme.primary
                                        )
                                        Text(
                                            text = "Holy Bible",
                                            style = MaterialTheme.typography.titleLarge,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.primary
                                        )
                                    }
                                },
                                actions = {
                                    IconButton(
                                        onClick = { currentRoute = NavRoutes.Settings.route },
                                        modifier = Modifier.testTag("top_bar_settings_icon")
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Settings,
                                            contentDescription = "Settings"
                                        )
                                    }
                                },
                                colors = TopAppBarDefaults.topAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.surface
                                )
                            )
                        }
                    },
                    bottomBar = {
                        BibleBottomBar(
                            currentRoute = currentRoute,
                            onNavigate = { route ->
                                currentRoute = route
                            }
                        )
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        when (currentRoute) {
                            NavRoutes.Home.route -> {
                                HomeScreen(
                                    viewModel = viewModel,
                                    onNavigateToReader = { book, chapter ->
                                        viewModel.loadChapter(book, chapter)
                                        currentRoute = NavRoutes.Reader.route
                                    },
                                    onNavigateToSearchWithTopic = { topic ->
                                        initialSearchTopic = topic
                                        currentRoute = NavRoutes.Search.route
                                    },
                                    onNavigateToPlans = {
                                        currentRoute = NavRoutes.Plans.route
                                    }
                                )
                            }

                            NavRoutes.Reader.route -> {
                                ReaderScreen(viewModel = viewModel)
                            }

                            NavRoutes.Books.route -> {
                                BooksScreen(
                                    viewModel = viewModel,
                                    onNavigateToReader = { book, chapter ->
                                        viewModel.loadChapter(book, chapter)
                                        currentRoute = NavRoutes.Reader.route
                                    }
                                )
                            }

                            NavRoutes.Search.route -> {
                                SearchScreen(
                                    viewModel = viewModel,
                                    initialTopic = initialSearchTopic,
                                    onNavigateToReader = { book, chapter ->
                                        viewModel.loadChapter(book, chapter)
                                        currentRoute = NavRoutes.Reader.route
                                    }
                                )
                            }

                            NavRoutes.Study.route -> {
                                StudyHubScreen(
                                    viewModel = viewModel,
                                    onNavigateToReader = { book, chapter ->
                                        viewModel.loadChapter(book, chapter)
                                        currentRoute = NavRoutes.Reader.route
                                    }
                                )
                            }

                            NavRoutes.Plans.route -> {
                                PlansScreen(
                                    viewModel = viewModel,
                                    onNavigateToReader = { book, chapter ->
                                        viewModel.loadChapter(book, chapter)
                                        currentRoute = NavRoutes.Reader.route
                                    }
                                )
                            }

                            NavRoutes.Settings.route -> {
                                SettingsScreen(viewModel = viewModel)
                            }
                        }
                    }
                }
            }
        }
    }
}
