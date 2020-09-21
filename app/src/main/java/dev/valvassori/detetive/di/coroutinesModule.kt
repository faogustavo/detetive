package dev.valvassori.detetive.di

import dev.valvassori.detetive.core.DefaultDispatcherProvider
import dev.valvassori.detetive.core.DispatcherProvider
import org.koin.dsl.module

val coroutinesModule = module {
    factory<DispatcherProvider> { DefaultDispatcherProvider }
}
