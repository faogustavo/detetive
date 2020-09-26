package dev.valvassori.detetive.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dev.valvassori.detetive.R
import dev.valvassori.detetive.containers.MainContainer
import dev.valvassori.detetive.ui.base.ComposableFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : ComposableFragment() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel
            .action
            .onEach { handleAction(it) }
            .launchIn(lifecycleScope)
    }

    @Composable
    override fun render() {
        MainContainer(mainViewModel)
    }

    private fun handleAction(action: MainAction?) {
        mainViewModel.onActionHandled(action)
        when (action) {
            is MainAction.EditCard -> {
                try {
                    val navAction = MainFragmentDirections.actionMainFragmentToEditCardDialog(
                        action.card
                    )
                    findNavController().navigate(navAction)
                } catch (e: IllegalArgumentException) {
                    Log.e("[Detetive]", e.message.orEmpty())
                }
            }
            is MainAction.ConfirmNewGame -> {
                AlertDialog.Builder(requireContext())
                    .setTitle(R.string.new_game_dialog_title)
                    .setMessage(R.string.new_game_dialog_description)
                    .setPositiveButton(R.string.new_game_dialog_positive) { dialog, _ ->
                        dialog.dismiss()
                        mainViewModel.dispatch(MainViewAction.ConfirmNewGame)
                    }
                    .setNegativeButton(R.string.new_game_dialog_negative) { dialog, _ ->
                        dialog.dismiss()
                    }
                    .create()
                    .show()
            }
        }
    }
}
