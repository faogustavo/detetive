package dev.valvassori.detective.ui.main

import androidx.compose.runtime.Composable
import dev.valvassori.detective.components.Greeting
import dev.valvassori.detective.ui.base.ComposableFragment
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : ComposableFragment() {

    private val mainViewModel: MainViewModel by viewModel()

    @Composable
    override fun render() {
        Greeting()
    }
}
