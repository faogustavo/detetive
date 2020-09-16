package dev.valvassori.detective.components.theme

import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

private val Primary = Color(0xFF322F3D)
private val PrimaryDark = Color(0xFF092532)
private val Accent = Color(0xFFFDDB3A)
private val AccentDark = Color(0xFFE4BE07)

internal val DetectiveLightPalette = lightColors(
    primary = Primary,
    primaryVariant = PrimaryDark,
    secondary = Accent,
    secondaryVariant = AccentDark,
)
