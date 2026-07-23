package com.example.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.example.ui.navigation.NavRoutes

@Composable
fun BibleBottomBar(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {
    val navItems = listOf(
        Triple(NavRoutes.Home, Icons.Filled.Home, Icons.Outlined.Home),
        Triple(NavRoutes.Reader, Icons.Filled.MenuBook, Icons.Outlined.MenuBook),
        Triple(NavRoutes.Books, Icons.Filled.AutoStories, Icons.Outlined.AutoStories),
        Triple(NavRoutes.Search, Icons.Filled.Search, Icons.Outlined.Search),
        Triple(NavRoutes.Study, Icons.Filled.Bookmark, Icons.Outlined.BookmarkBorder),
        Triple(NavRoutes.Plans, Icons.Filled.CalendarMonth, Icons.Outlined.CalendarMonth)
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
        tonalElevation = NavigationBarDefaults.Elevation
    ) {
        navItems.forEach { (item, filledIcon, outlinedIcon) ->
            val isSelected = currentRoute == item.route
            NavigationBarItem(
                selected = isSelected,
                onClick = { onNavigate(item.route) },
                icon = {
                    Icon(
                        imageVector = if (isSelected) filledIcon else outlinedIcon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title, style = MaterialTheme.typography.labelSmall) },
                modifier = Modifier.testTag(item.testTag)
            )
        }
    }
}
