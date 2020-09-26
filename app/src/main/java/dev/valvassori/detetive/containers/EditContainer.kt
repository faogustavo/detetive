package dev.valvassori.detetive.containers

import android.util.Log
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import dev.valvassori.detetive.R
import dev.valvassori.detetive.components.BottomDialog
import dev.valvassori.detetive.components.card.CardLocationRow
import dev.valvassori.detetive.components.theme.DetectiveTheme
import dev.valvassori.detetive.core.ext.func.Callback0
import dev.valvassori.detetive.core.ext.func.Callback1
import dev.valvassori.detetive.domain.model.Card
import dev.valvassori.detetive.domain.model.Location
import dev.valvassori.detetive.ui.edit.EditViewAction
import dev.valvassori.detetive.ui.edit.EditViewModel

@Composable
fun EditContainer(editViewModel: EditViewModel) {
    DetectiveTheme {
        val card by editViewModel.card.collectAsState()
        val location by editViewModel.location.collectAsState()
        val description by editViewModel.description.collectAsState()

        EditContent(
            card = card,
            selectedOption = location,
            description = description,
            onLocationSelected = {
                editViewModel.dispatch(EditViewAction.ChangeLocation(it))
            },
            onTextChanged = {
                editViewModel.dispatch(EditViewAction.UpdateObservation(it))
            },
            onFinishEdit = {
                editViewModel.dispatch(EditViewAction.Save(isAutoSave = false))
            }
        )
    }
}

@Composable
fun EditContent(
    card: Card?,
    selectedOption: Location?,
    description: String,
    onLocationSelected: Callback1<Location> = {},
    onTextChanged: Callback1<String> = {},
    onFinishEdit: Callback0 = {},
) {
    if (card == null || selectedOption == null) return

    BottomDialog {
        val cardName = stringResource(id = card.cardName)
        val title = stringResource(
            id = R.string.edit_dialog_title_format,
            formatArgs = arrayOf(cardName)
        )

        Text(
            text = title,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.h6
        )

        Text(
            text = stringResource(id = R.string.edit_dialog_location_title),
            modifier = Modifier.padding(top = 4.dp)
        )

        CardLocationRow(
            selectedOption = selectedOption,
            onClick = onLocationSelected
        )

        Text(
            text = stringResource(id = R.string.edit_dialog_location_observation),
            modifier = Modifier.padding(top = 4.dp)
        )

        TextField(
            value = description,
            onValueChange = {
                Log.d("FAOGUSTAVO", "TextField.onValueChange($it) called")
                onTextChanged(it)
            },
            imeAction = ImeAction.Done,
            onImeActionPerformed = { _, _ -> onFinishEdit() },
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = Color.Transparent
        )
    }
}

@Preview
@Composable
fun PreviewEditContent() {
    DetectiveTheme {
        EditContent(
            card = Card.HOTEL,
            selectedOption = Location.HAND,
            description = "Lorem Ipsum",
        )
    }
}
