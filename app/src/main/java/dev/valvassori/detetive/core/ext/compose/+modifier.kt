package dev.valvassori.detetive.core.ext.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

fun Modifier.padding(
    vertical: Dp,
    horizontal: Dp
) = padding(
    top = vertical,
    bottom = vertical,
    start = horizontal,
    end = horizontal
)
