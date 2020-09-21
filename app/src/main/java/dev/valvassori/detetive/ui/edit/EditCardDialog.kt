package dev.valvassori.detetive.ui.edit

import androidx.compose.runtime.Composable
import androidx.navigation.fragment.navArgs
import dev.valvassori.detetive.containers.EditContainer
import dev.valvassori.detetive.ui.base.ComposableBottomSheetDialog

class EditCardDialog : ComposableBottomSheetDialog() {

    val args: EditCardDialogArgs by navArgs()

    @Composable
    override fun render() {
        EditContainer(args.card)
    }
}
