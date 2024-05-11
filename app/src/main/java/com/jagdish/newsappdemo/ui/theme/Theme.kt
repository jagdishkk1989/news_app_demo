package com.jagdish.newsappdemo.presentation.ui.theme

import LightBlue
import Navy
import PurpleGrey40
import PurpleGrey80
import Shapes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Navy,
    secondary = PurpleGrey80,
)


private val LightColorPalette = lightColors(
    primary = LightBlue,
    secondary = PurpleGrey40,
)

@Composable
fun NewsAppDemoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}