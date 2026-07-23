package com.example.ui.navigation

sealed class NavRoutes(val route: String, val title: String, val testTag: String) {
    object Home : NavRoutes("home", "Home", "nav_home")
    object Reader : NavRoutes("reader", "Scripture", "nav_reader")
    object Books : NavRoutes("books", "Books", "nav_books")
    object Search : NavRoutes("search", "Search", "nav_search")
    object Study : NavRoutes("study", "Study Hub", "nav_study")
    object Plans : NavRoutes("plans", "Plans", "nav_plans")
    object Settings : NavRoutes("settings", "Settings", "nav_settings")
}
