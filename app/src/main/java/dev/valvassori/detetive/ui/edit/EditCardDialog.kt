package dev.valvassori.detetive.ui.edit

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import dev.valvassori.detetive.containers.EditContainer
import dev.valvassori.detetive.ui.base.ComposableBottomSheetDialog
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.android.viewmodel.ext.android.viewModel

class EditCardDialog : ComposableBottomSheetDialog() {

    val args: EditCardDialogArgs by navArgs()
    val editViewModel: EditViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editViewModel.dispatch(EditViewAction.Init(args.card))
        editViewModel
            .action
            .onEach { handleAction(it) }
            .launchIn(lifecycleScope)
    }

    @Composable
    override fun render() {
        EditContainer(editViewModel)
    }

    private fun handleAction(action: EditAction?) {
        when (action) {
            is EditAction.Dismiss -> dismiss()
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        editViewModel.dispatch(EditViewAction.Save(isAutoSave = true))
        super.onDismiss(dialog)
    }
}
