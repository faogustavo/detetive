package dev.valvassori.detective.domain.model

import junit.framework.Assert.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Assert.assertEquals
import org.junit.Test

class GameCardTest {

    @Test
    fun name_returnsCardName() {
        val card = Card.values().random()
        val subject = GameCard(card = card)

        val result = subject.name

        assertEquals(card.cardName, result)
    }

    @Test
    fun color_returnsCardName() {
        val card = Card.values().random()
        val subject = GameCard(card = card)

        val result = subject.color

        assertEquals(card.color, result)
    }

    @Test
    fun type_returnsCardName() {
        val card = Card.values().random()
        val subject = GameCard(card = card)

        val result = subject.type

        assertEquals(card.type, result)
    }

    @Test
    fun areItemsTheSame_withSameCard_returnTrue() {
        val card = Card.values().random()
        val subject = GameCard(card = card)
        val other = GameCard(card = card)

        val result = subject.areItemsTheSame(other)

        assertTrue(result)
    }

    @Test
    fun areItemsTheSame_withDifferentCard_returnTrue() {
        val subject = GameCard(card = Card.BANK)
        val other = GameCard(card = Card.BUTLER)

        val result = subject.areItemsTheSame(other)

        assertFalse(result)
    }

    @Test
    fun areContentSame_withSameItem_returnTrue() {
        val card = Card.values().random()

        val subject = GameCard(card = card, location = Location.HAND)
        val other = subject.copy()

        val result = subject.areContentSame(other)

        assertTrue(result)
    }

    @Test
    fun areContentSame_withDifferenmtItem_returnFalse() {
        val card = Card.values().random()

        val subject = GameCard(card = card, location = Location.MAYBE_HAND)
        val other = subject.copy(location = Location.HAND)

        val result = subject.areContentSame(other)

        assertFalse(result)
    }
}
