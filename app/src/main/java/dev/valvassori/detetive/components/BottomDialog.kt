package dev.valvassori.detetive.components

import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import dev.valvassori.detetive.components.theme.DetectiveTheme

@Composable
fun BottomDialog(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.background,
    isPullIconVisible: Boolean = true,
    children: @Composable ColumnScope.() -> Unit,
) {
    val dialogShape = RoundedCornerShape(
        topLeft = 4.dp,
        topRight = 4.dp
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor, shape = dialogShape)
            .padding(horizontal = 16.dp, vertical = 8.dp),
    ) {
        if (isPullIconVisible) {
            Box(
                modifier = Modifier
                    .preferredSize(
                        width = 32.dp,
                        height = 3.dp
                    )
                    .align(Alignment.CenterHorizontally),
                backgroundColor = Color.Gray,
                shape = RoundedCornerShape(3.dp)
            )

            Spacer(modifier = Modifier.preferredSize(8.dp))
        }

        children()
    }
}

@Preview
@Composable
fun PreviewBottomDialog() {
    DetectiveTheme {
        BottomDialog {
            Text(text = "Hello Dialog")
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Click Me")
            }
        }
    }
}

@Preview
@Composable
fun PreviewBottomDialogVariant() {
    DetectiveTheme {
        BottomDialog(isPullIconVisible = false) {
            Text(text = "Hello Dialog")
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Click Me")
            }
        }
    }
}
