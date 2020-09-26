package dev.valvassori.detetive.ui.main

import dev.valvassori.detetive.domain.model.Card

sealed class MainAction {
    class EditCard(val card: Card) : MainAction()
    object ConfirmNewGame : MainAction()
}
