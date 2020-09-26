package dev.valvassori.detetive.di

import dev.valvassori.detetive.data.usecase.GetCardsUseCase
import dev.valvassori.detetive.data.usecase.GetGameCardUseCase
import dev.valvassori.detetive.domain.usecases.NewGameUseCase
import dev.valvassori.detetive.domain.usecases.UpdateCardUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetCardsUseCase(get()) }
    factory { NewGameUseCase(get()) }
    factory { UpdateCardUseCase(get()) }
    factory { GetGameCardUseCase(get()) }
}
