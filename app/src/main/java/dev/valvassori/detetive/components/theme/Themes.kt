package dev.valvassori.detetive.components.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import dev.valvassori.detetive.components.ext.ComposableFn

@Composable
fun DetectiveTheme(
    content: ComposableFn,
) {
    MaterialTheme(
        colors = DetectiveLightPalette,
        content = content
    )
}
