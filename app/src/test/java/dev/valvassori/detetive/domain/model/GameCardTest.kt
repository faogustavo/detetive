package dev.valvassori.detetive.domain.model

import dev.valvassori.detetive.factory.GameCardTestFactory
import junit.framework.TestCase.assertTrue
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

private const val DESCRIPTION_TEMPLATE = "• %s"
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
    fun hasColor_withColor_returnsTrue() {
        val subject = GameCard(card = Card.BUTLER)

        val result = subject.hasColor

        assertTrue(result)
    }

    @Test
    fun hasColor_withoutColor_returnsFalse() {
        val subject = GameCard(card = Card.HOTEL)

        val result = subject.hasColor

        assertFalse(result)
    }

    @Test
    fun type_returnsCardName() {
        val card = Card.values().random()
        val subject = GameCard(card = card)

        val result = subject.type

        assertEquals(card.type, result)
    }

    @Test
    fun hasDescription_withDescription_returnsTrue() {
        val subject = GameCardTestFactory
            .randomCard()
            .copy(description = "Foo Bar")

        val result = subject.hasDescription

        assertTrue(result)
    }

    @Test
    fun hasDescription_withoutDescription_returnsFalse() {
        val subject = GameCardTestFactory
            .randomCard()
            .copy(description = null)

        val result = subject.hasDescription

        assertFalse(result)
    }

    @Test
    fun prettyDescription_withDescription_returnsText() {
        val description = "Foo Bar"
        val subject = GameCardTestFactory
            .randomCard()
            .copy(description = description)

        val result = subject.prettyDescription
        val expectedResult = DESCRIPTION_TEMPLATE.format(description)

        assertEquals(expectedResult, result)
    }

    @Test
    fun prettyDescription_withoutDescription_returnsEmpty() {
        val subject = GameCardTestFactory
            .randomCard()
            .copy(description = null)

        val result = subject.prettyDescription
        val expectedResult = ""

        assertEquals(expectedResult, result)
    }

    @Test
    fun locationColor_returnsLocationColor() {
        val subject = GameCardTestFactory.randomCard()

        val result = subject.locationColor
        val expectedResult = subject.location.color

        assertEquals(expectedResult, result)
    }

    @Test
    fun locationText_returnsLocationText() {
        val subject = GameCardTestFactory.randomCard()

        val result = subject.locationText
        val expectedResult = subject.location.text

        assertEquals(expectedResult, result)
    }
}
