package dev.valvassori.detetive.ui.main

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
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
        when (action) {
            is MainAction.EditCard -> {
                val navAction = MainFragmentDirections.actionMainFragmentToEditCardDialog(
                    action.card
                )
                findNavController().navigate(navAction)
            }
        }
    }
}
