package dev.valvassori.detetive.domain.factory

import dev.valvassori.detetive.domain.model.Card
import dev.valvassori.detetive.domain.model.GameCard

object GameCardFactory {

    fun make(): List<GameCard> = Card.values().map {
        GameCard(card = it)
    }
}
