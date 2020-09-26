package dev.valvassori.detetive.components.card

import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.Dimension
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import dev.valvassori.detetive.components.shapes.Circle
import dev.valvassori.detetive.components.shapes.RoundedCornerSquare
import dev.valvassori.detetive.components.theme.DetectiveTheme
import dev.valvassori.detetive.core.ext.func.Callback1
import dev.valvassori.detetive.domain.model.Card
import dev.valvassori.detetive.domain.model.GameCard
import dev.valvassori.detetive.domain.model.Location

@Composable
fun CardList(
    cards: List<GameCard>,
    onCardClick: Callback1<GameCard> = {},
) {
    LazyColumnFor(
        items = cards
    ) { card -> CardItem(card, onCardClick = onCardClick) }
}

@Composable
fun CardItem(
    card: GameCard,
    onCardClick: Callback1<GameCard> = {},
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onCardClick(card) })
    ) {
        val (cardLocation, cardColor, cardText, cardDescription, divider) = createRefs()

        RoundedCornerSquare(
            color = colorResource(id = card.locationColor),
            text = stringResource(id = card.locationText),
            modifier = Modifier.constrainAs(cardLocation) {
                top.linkTo(parent.top, margin = 12.dp)
                end.linkTo(parent.end, margin = 16.dp)
            },
        )

        val color = card.color
        if (color != null) {
            Circle(
                color = colorResource(id = color),
                modifier = Modifier.constrainAs(cardColor) {
                    top.linkTo(cardLocation.top)
                    bottom.linkTo(cardLocation.bottom)
                    start.linkTo(parent.start, margin = 16.dp)
                }
            )
        }

        Text(
            text = stringResource(id = card.name),
            maxLines = 1,
            modifier = Modifier.constrainAs(cardText) {
                width = Dimension.fillToConstraints

                top.linkTo(cardLocation.top)
                bottom.linkTo(cardLocation.bottom)
                end.linkTo(cardLocation.start, margin = 8.dp)

                if (card.hasColor) {
                    start.linkTo(cardColor.end, margin = 8.dp)
                } else {
                    start.linkTo(parent.start, margin = 16.dp)
                }
            },
        )

        if (card.hasDescription) {
            Text(
                text = card.prettyDescription,
                maxLines = 1,
                modifier = Modifier.constrainAs(cardDescription) {
                    top.linkTo(cardLocation.bottom, margin = 4.dp)
                    start.linkTo(parent.start, margin = 24.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                    width = Dimension.fillToConstraints
                },
            )
        }

        val barrier = if (card.hasDescription) {
            createBottomBarrier(cardText, cardDescription)
        } else {
            createBottomBarrier(cardText)
        }

        Divider(
            modifier = Modifier.constrainAs(divider) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                top.linkTo(barrier, 12.dp)
            }
        )
    }
}

@Preview
@Composable
fun PreviewCardItemWithDescription() {
    DetectiveTheme {
        CardItem(
            card = GameCard(
                Location.HAND,
                description = "Gustavo",
                card = Card.GRAVEDIGGER,
            )
        )
    }
}

@Preview
@Composable
fun PreviewCardItemWithoutDescription() {
    DetectiveTheme {
        CardItem(
            card = GameCard(
                Location.UNKNOWN,
                card = Card.FLORIST,
            )
        )
    }
}

@Preview
@Composable
fun PreviewCardItemWithoutColor() {
    DetectiveTheme {
        CardItem(
            card = GameCard(
                Location.MAYBE_ENVELOP,
                description = "Gustavo",
                card = Card.HOTEL,
            )
        )
    }
}

@Preview
@Composable
fun PreviewCardList() {
    DetectiveTheme {
        CardList(
            cards = listOf(
                GameCard(
                    Location.MAYBE_ENVELOP,
                    description = "Gustavo",
                    card = Card.GRAVEDIGGER,
                ),
                GameCard(
                    Location.HAND,
                    description = "Gustavo",
                    card = Card.HOTEL,
                ),
                GameCard(
                    Location.ENVELOP,
                    card = Card.KNIFE,
                )
            )
        )
    }
}
