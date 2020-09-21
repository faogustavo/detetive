package dev.valvassori.detetive.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.valvassori.detetive.core.DispatcherProvider
import dev.valvassori.detetive.core.ext.flow.collectTo
import dev.valvassori.detetive.data.usecase.GetCardsUseCase
import dev.valvassori.detetive.domain.model.GameCard
import dev.valvassori.detetive.domain.model.Type
import dev.valvassori.detetive.domain.usecases.NewGameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class MainViewModel constructor(
    private val newGame: NewGameUseCase,
    private val getCards: GetCardsUseCase,
    dispatcherProvider: DispatcherProvider,
) : ViewModel() {

    private val _selectedTab = MutableStateFlow(Type.CHARACTER)
    private val _state = MutableStateFlow(MainViewState())

    val state: StateFlow<MainViewState>
        get() = _state

    init {
        viewModelScope.launch(dispatcherProvider.default) {
            combine(getCards(), _selectedTab) { cards, type ->
                MainViewState(type, cards.filter { it.type == type })
            }.collectTo(_state)
        }
    }

    fun dispatch(action: MainViewAction) {
        when (action) {
            is MainViewAction.NewGame -> actionNewGame()
            is MainViewAction.ChangeTab -> actionChangeTab(action.newTab)
            is MainViewAction.EditCard -> actionEditCard(action.card)
        }
    }

    private fun actionNewGame() {
        newGame()
    }

    private fun actionChangeTab(newTab: Type) {
        _selectedTab.value = newTab
    }

    private fun actionEditCard(card: GameCard) {
        // TODO: Dispatch action to view open a dialog and update the card
    }
}
