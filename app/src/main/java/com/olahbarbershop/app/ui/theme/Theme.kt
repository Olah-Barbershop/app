package com.olahbarbershop.app.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val ColorPalette = darkColors(
    background = Grey900,
    surface = RealBlack,
    onSurface = White,
    primary = Grey800,
    onPrimary = Grey400,
    secondary = Grey400
)

@Composable
fun OlahBarbershopTheme(
    content: @Composable () -> Unit
) {
    val colors = ColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}