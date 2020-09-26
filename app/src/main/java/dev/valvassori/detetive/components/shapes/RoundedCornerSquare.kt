package dev.valvassori.detetive.components.shapes

import androidx.compose.foundation.Box
import androidx.compose.foundation.ContentGravity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RoundedCornerSquare(
    color: Color,
    size: Dp = 24.dp,
    cornerSize: Dp = 4.dp,
    modifier: Modifier = Modifier,
    text: String = "",
) {
    Box(
        modifier = modifier.preferredSize(size),
        backgroundColor = color,
        shape = RoundedCornerShape(cornerSize),
        gravity = ContentGravity.Center,
        children = {
            Text(
                text = text,
                style = MaterialTheme.typography.caption,
            )
        }
    )
}
