package dev.valvassori.detetive.ui.edit

import androidx.lifecycle.ViewModel
import dev.valvassori.detetive.data.usecase.GetGameCardUseCase
import dev.valvassori.detetive.domain.model.Card
import dev.valvassori.detetive.domain.model.GameCard
import dev.valvassori.detetive.domain.model.Location
import dev.valvassori.detetive.domain.usecases.UpdateCardUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class EditViewModel constructor(
    private val getGameCard: GetGameCardUseCase,
    private val updateCard: UpdateCardUseCase,
) : ViewModel() {

    private val _card: MutableStateFlow<Card?> = MutableStateFlow(null)
    private val _location: MutableStateFlow<Location?> = MutableStateFlow(Location.HAND)
    private val _text: MutableStateFlow<String> = MutableStateFlow("")
    private val _action: MutableStateFlow<EditAction?> = MutableStateFlow(null)

    val card: StateFlow<Card?>
        get() = _card

    val location: StateFlow<Location?>
        get() = _location

    val description: StateFlow<String>
        get() = _text

    val action: StateFlow<EditAction?>
        get() = _action

    fun dispatch(action: EditViewAction) {
        when (action) {
            is EditViewAction.Init -> initViewModel(action.card)
            is EditViewAction.ChangeLocation -> changeLocation(action.newLocation)
            is EditViewAction.UpdateObservation -> updateObservation(action.text)
            is EditViewAction.Save -> save(action.isAutoSave)
        }
    }

    private fun initViewModel(card: Card) {
        val gameCard = getGameCard(card)

        _card.value = gameCard?.card
        _location.value = gameCard?.location
        _text.value = gameCard?.description.orEmpty()
    }

    private fun changeLocation(newLocation: Location) {
        _location.value = newLocation
    }

    private fun updateObservation(text: String) {
        _text.value = text
    }

    private fun save(autoSave: Boolean) {
        val card = _card.value
        val location = _location.value
        val text = _text.value.takeIf { it.isBlank().not() }

        if (card != null && location != null) {
            updateCard(
                GameCard(
                    location = location,
                    description = text,
                    card = card
                )
            )
        }

        if (!autoSave) {
            _action.value = EditAction.Dismiss
        }
    }
}
