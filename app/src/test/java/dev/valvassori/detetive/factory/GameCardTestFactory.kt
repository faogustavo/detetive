package dev.valvassori.detetive.factory

import dev.valvassori.detetive.domain.model.Card
import dev.valvassori.detetive.domain.model.GameCard
import dev.valvassori.detetive.domain.model.Location

object GameCardTestFactory {

    fun newGameCards() = listOf(
        GameCard(card = Card.BANK),
        GameCard(card = Card.CENTRAL_PARK),
        GameCard(card = Card.BUTLER),
        GameCard(card = Card.CHEF),
        GameCard(card = Card.CHEMICAL_WEAPON),
        GameCard(card = Card.CROWBAR),
    )

    fun runningGameCards() = newGameCards().map {
        it.copy(location = Location.values().random())
    }

    fun randomCard() = runningGameCards().random()
}
