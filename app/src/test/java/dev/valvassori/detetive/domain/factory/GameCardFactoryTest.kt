package dev.valvassori.detetive.domain.factory

import dev.valvassori.detetive.domain.model.Card
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
