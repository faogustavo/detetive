package dev.valvassori.detetive.di

import dev.valvassori.detetive.data.datasource.CardDataSource
import dev.valvassori.detetive.data.datasource.impl.CardsLocalDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.core.qualifier.named
import org.koin.dsl.module

@ExperimentalCoroutinesApi
val dataSourceModule = module {
    factory<CardDataSource> { CardsLocalDataSource(get(named(CacheNames.CARDS))) }
}
