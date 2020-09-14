package dev.valvassori.detective.domain.factory

import dev.valvassori.detective.domain.model.Card
import org.junit.Assert.assertEquals
import org.junit.Test

class GameCardFactoryTest {

    @Test
    fun make_generateGameCardForAllCards() {
        val expectedResult = Card.values().toSet()

        val result = GameCardFactory.make().map { it.card }.toSet()

        assertEquals(expectedResult, result)
    }
}
