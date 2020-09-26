package dev.valvassori.detetive.components.shapes

import androidx.compose.foundation.Box
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Circle(
    color: Color,
    modifier: Modifier = Modifier,
    size: Dp = 24.dp,
) {
    Box(
        modifier = modifier.preferredSize(size),
        backgroundColor = color,
        shape = CircleShape
    )
}
