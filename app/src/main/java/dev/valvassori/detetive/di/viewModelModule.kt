package dev.valvassori.detetive.di

import dev.valvassori.detetive.ui.edit.EditViewModel
import dev.valvassori.detetive.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get(), get(), get()) }
    viewModel { EditViewModel(get(), get()) }
}
