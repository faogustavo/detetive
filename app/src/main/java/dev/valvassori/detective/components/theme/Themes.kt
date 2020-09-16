package dev.valvassori.detective.components.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import dev.valvassori.detective.components.ext.ComposableFn

@Composable
fun DetectiveTheme(
    content: ComposableFn,
) {
    MaterialTheme(
        colors = DetectiveLightPalette,
        content = content
    )
}
