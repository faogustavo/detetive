package dev.valvassori.detetive.ui.main

import dev.valvassori.detetive.domain.model.GameCard
import dev.valvassori.detetive.domain.model.Type

class MainViewState(
    val selectedTab: Type = Type.CHARACTER,
    val cards: List<GameCard> = emptyList(),
)
