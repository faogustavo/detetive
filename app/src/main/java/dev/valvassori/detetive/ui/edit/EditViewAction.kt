package dev.valvassori.detetive.ui.edit

import dev.valvassori.detetive.domain.model.Card
import dev.valvassori.detetive.domain.model.Location

sealed class EditViewAction {
    class Init(val card: Card) : EditViewAction()
    class ChangeLocation(val newLocation: Location) : EditViewAction()
    class UpdateObservation(val text: String) : EditViewAction()
    class Save(val isAutoSave: Boolean) : EditViewAction()
}
