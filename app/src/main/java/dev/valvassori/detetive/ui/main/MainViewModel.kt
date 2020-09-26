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
    private val _action: MutableStateFlow<MainAction?> = MutableStateFlow(null)

    val state: StateFlow<MainViewState>
        get() = _state

    val action: MutableStateFlow<MainAction?>
        get() = _action

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
            is MainViewAction.ConfirmNewGame -> actionConfirmNewGame()
            is MainViewAction.ChangeTab -> actionChangeTab(action.newTab)
            is MainViewAction.EditCard -> actionEditCard(action.card)
        }
    }

    fun onActionHandled(action: MainAction?) {
        if (action != null && _action.value == action) {
            _action.value = null
        }
    }

    private fun actionNewGame() {
        _action.value = MainAction.ConfirmNewGame
    }

    private fun actionConfirmNewGame() {
        newGame()
    }

    private fun actionChangeTab(newTab: Type) {
        _selectedTab.value = newTab
    }

    private fun actionEditCard(card: GameCard) {
        _action.value = MainAction.EditCard(card.card)
    }
}
