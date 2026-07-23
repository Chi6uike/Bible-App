package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = NaturalDarkSagePrimary,
    onPrimary = NaturalDarkBackground,
    primaryContainer = NaturalDarkSageContainer,
    onPrimaryContainer = NaturalDarkText,
    secondary = NaturalDarkOak,
    onSecondary = NaturalDarkBackground,
    background = NaturalDarkBackground,
    onBackground = NaturalDarkText,
    surface = NaturalDarkSurface,
    onSurface = NaturalDarkText,
    surfaceVariant = NaturalDarkSurfaceVariant,
    onSurfaceVariant = NaturalDarkTextSecondary,
    outline = Color(0xFF3C423D)
)

private val LightColorScheme = lightColorScheme(
    primary = NaturalSagePrimary,
    onPrimary = Color.White,
    primaryContainer = NaturalSageLightContainer,
    onPrimaryContainer = NaturalSagePrimary,
    secondary = NaturalOakBrown,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFF2ECE1),
    onSecondaryContainer = NaturalOakBrown,
    background = NaturalBackground,
    onBackground = NaturalText,
    surface = NaturalSurface,
    onSurface = NaturalText,
    surfaceVariant = NaturalSurfaceVariant,
    onSurfaceVariant = NaturalTextSecondary,
    outline = Color(0xFFE5DFD7)
)

@Composable
fun BibleAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Preserve brand parchment & burgundy styling
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
