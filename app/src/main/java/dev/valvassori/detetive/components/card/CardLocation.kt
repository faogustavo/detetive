package dev.valvassori.detetive.components.card

import androidx.compose.foundation.Text
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ConstrainedLayoutReference
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.Dimension
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import dev.valvassori.detetive.components.shapes.RoundedCornerSquare
import dev.valvassori.detetive.components.theme.DetectiveTheme
import dev.valvassori.detetive.core.ext.func.Callback1
import dev.valvassori.detetive.domain.model.Location

@Composable
fun CardLocationRow(
    selectedOption: Location,
    locations: List<Location> = listOf(
        Location.UNKNOWN,
        Location.MAYBE_HAND,
        Location.MAYBE_ENVELOP,
        Location.HAND,
        Location.ENVELOP,
    ),
    onClick: Callback1<Location> = {},
) {
    ConstraintLayout(
        Modifier.fillMaxWidth()
    ) {
        val refList = mutableListOf<ConstrainedLayoutReference>()
        val expectedSize = (1f / locations.size) - 0.02f

        locations.forEach { cardLocation ->
            val itemRef = createRef().also { refList.add(it) }
            CardLocation(
                cardLocation = cardLocation,
                isSelected = cardLocation == selectedOption,
                modifier = Modifier
                    .constrainAs(itemRef) {
                        width = Dimension.percent(expectedSize)
                    }
                    .clickable(onClick = { onClick(cardLocation) })
            )
        }

        createHorizontalChain(*refList.toTypedArray())
    }
}

@Composable
fun CardLocation(
    modifier: Modifier = Modifier,
    cardLocation: Location,
    isSelected: Boolean,
) {
    var updatedModifier = modifier
    val selectionShape = RoundedCornerShape(4.dp)

    if (isSelected) {
        updatedModifier = updatedModifier.border(
            width = 1.dp,
            color = MaterialTheme.colors.secondary,
            shape = selectionShape
        )
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = updatedModifier.padding(
            horizontal = 4.dp,
            vertical = 8.dp
        ),
    ) {
        RoundedCornerSquare(
            color = colorResource(id = cardLocation.color),
        )
        Text(
            text = stringResource(id = cardLocation.text),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview
@Composable
fun PreviewCardLocation() {
    DetectiveTheme {
        CardLocationRow(selectedOption = Location.HAND)
    }
}
