package dev.valvassori.detetive.di

import dev.valvassori.detetive.data.datasource.generic.HawkDataSource
import dev.valvassori.detetive.domain.model.GameCard
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val CARDS_CACHE = "cards_cache"

enum class CacheNames() {
    CARDS
}

val cacheModule = module {
    single(named(CacheNames.CARDS)) { HawkDataSource<List<GameCard>>(CARDS_CACHE) }
}
