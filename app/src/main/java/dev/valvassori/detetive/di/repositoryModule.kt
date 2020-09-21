package dev.valvassori.detetive.di

import dev.valvassori.detetive.data.repository.GameCardsRepository
import dev.valvassori.detetive.data.repository.impl.GameCardsDefaultRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<GameCardsRepository> { GameCardsDefaultRepository(get()) }
}
