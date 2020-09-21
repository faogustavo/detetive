package dev.valvassori.detetive.ui.main

import androidx.compose.runtime.Composable
import dev.valvassori.detetive.containers.MainContainer
import dev.valvassori.detetive.ui.base.ComposableFragment
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : ComposableFragment() {

    private val mainViewModel: MainViewModel by viewModel()

    @Composable
    override fun render() {
        MainContainer(mainViewModel)
    }
}
