package dev.valvassori.detective.domain.factory

import dev.valvassori.detective.domain.model.Card
import dev.valvassori.detective.domain.model.GameCard

object GameCardFactory {

    fun make(): List<GameCard> = Card.values().map {
        GameCard(card = it)
    }
}
