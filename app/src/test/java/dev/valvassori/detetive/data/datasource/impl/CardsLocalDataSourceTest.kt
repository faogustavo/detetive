package dev.valvassori.detetive.data.datasource.impl

import dev.valvassori.detetive.data.datasource.generic.HawkDataSource
import dev.valvassori.detetive.domain.factory.GameCardFactory
import dev.valvassori.detetive.domain.model.GameCard
import dev.valvassori.detetive.factory.GameCardTestFactory
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.unmockkObject
import io.mockk.verify
import org.junit.AfterClass
import org.junit.Assert.assertEquals
import org.junit.Test

class CardsLocalDataSourceTest {

    companion object {

        @AfterClass
        fun afterClass() {
            unmockkObject(GameCardFactory)
        }
    }

    private val cache: HawkDataSource<List<GameCard>> = mockk()
    private val subject by lazy { CardsLocalDataSource(cache) }

    @Test
    fun getCards_withExistingCards_returnsCacheValue() {
        val gameCards = GameCardTestFactory.runningGameCards()
        mock(currentGameCards = gameCards)

        val result = subject.getCards()

        assertEquals(gameCards, result)
    }

    @Test
    fun getCards_withExistingCards_callsCache() {
        mock(currentGameCards = GameCardTestFactory.runningGameCards())

        subject.getCards()

        verify(exactly = 1) {
            cache.exists()
            cache.get()
        }
    }

    @Test
    fun getCards_withoutExistingCards_returnEmptyList() {
        mock()

        val result = subject.getCards()

        assertEquals(emptyList<GameCard>(), result)
    }

    @Test
    fun getCards_withoutExistingCards_notCallsCache() {
        mock()

        subject.getCards()

        verify(exactly = 1) { cache.exists() }
        verify(exactly = 0) { cache.get() }
    }

    @Test
    fun updateCard_updatesCardOnTheCache() {
        val currentGameCards = GameCardTestFactory.newGameCards()
        val updatedCard = GameCardTestFactory.randomCard()

        mock(currentGameCards = currentGameCards)

        subject.updateCard(updatedCard)

        verify(exactly = 1) {
            cache.set(
                withArg { data ->
                    val index = data.indexOfFirst { it.card == updatedCard.card }
                    assertEquals(updatedCard, data[index])
                }
            )
        }
    }

    @Test
    fun newGame_updatesCache() {
        val newGameCards = GameCardTestFactory.newGameCards()
        mock(
            currentGameCards = GameCardTestFactory.runningGameCards(),
            newGameCards = newGameCards
        )

        subject.newGame()

        verify(exactly = 1) {
            cache.set(newGameCards)
        }
    }

    fun mock(
        currentGameCards: List<GameCard>? = null,
        newGameCards: List<GameCard> = GameCardTestFactory.newGameCards(),
    ) {
        // Cache Mocks
        every { cache.set(any()) } just Runs
        every { cache.exists() } returns (currentGameCards != null)

        if (currentGameCards != null) {
            every { cache.get() } returns currentGameCards
        }

        // Factory Mocks
        mockkObject(GameCardFactory)
        every { GameCardFactory.make() } returns newGameCards
    }
}
