package dev.valvassori.detetive.ui.main

import dev.valvassori.detetive.domain.model.GameCard
import dev.valvassori.detetive.domain.model.Type

sealed class MainViewAction {
    object NewGame : MainViewAction()
    class ChangeTab(val newTab: Type) : MainViewAction()
    class EditCard(val card: GameCard) : MainViewAction()
}
