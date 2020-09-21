package dev.valvassori.detetive.containers

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import dev.valvassori.detetive.components.theme.DetectiveTheme
import dev.valvassori.detetive.domain.model.Card

@Composable
fun EditContainer(card: Card) {
    DetectiveTheme {
        EditContent(card)
    }
}

@Composable
fun EditContent(card: Card) {
    val dialogShape = RoundedCornerShape(
        topLeft = 4.dp,
        topRight = 4.dp
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = dialogShape)
            .padding(horizontal = 16.dp, vertical = 8.dp),
    ) {
        val cardName = stringResource(id = card.cardName)

        Text(text = "Hello $cardName")
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Click me")
        }
    }
}

@Preview
@Composable
fun PreviewEditContent() {
    DetectiveTheme {
        EditContent(Card.HOTEL)
    }
}
