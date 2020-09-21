package dev.valvassori.detetive.data.repository.impl

import dev.valvassori.detetive.data.datasource.CardDataSource
import dev.valvassori.detetive.domain.model.GameCard
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert.assertEquals
import org.junit.Test

class GameCardsDefaultRepositoryTest {

    private val cardDataSource: CardDataSource = mockk()
    private val subject = GameCardsDefaultRepository(cardDataSource)

    @Test
    fun cardsStream_returnsValueFromDataSource() {
        val cardsFlow: Flow<List<GameCard>> = flowOf(listOf(mockk()))
        mock(
            cardsFlow = cardsFlow
        )

        val result = subject.cardsStream

        assertEquals(cardsFlow, result)
        verify(exactly = 1) { cardDataSource.cardsStream }
    }

    @Test
    fun newGame_callsDataSource() {
        mock()

        subject.newGame()

        verify(exactly = 1) { cardDataSource.newGame() }
    }

    @Test
    fun getCards_returnsValueFromDataSource() {
        val cards: List<GameCard> = listOf(mockk())
        mock(
            cards = cards
        )

        val result = subject.getCards()

        assertEquals(cards, result)
        verify(exactly = 1) { cardDataSource.getCards() }
    }

    @Test
    fun updateCard_callsDataSource() {
        val argument: GameCard = mockk()
        mock()

        subject.updateCard(argument)

        verify(exactly = 1) { cardDataSource.updateCard(argument) }
    }

    private fun mock(
        cards: List<GameCard> = emptyList(),
        cardsFlow: Flow<List<GameCard>> = flowOf(cards),
    ) {
        every { cardDataSource.cardsStream } returns cardsFlow
        every { cardDataSource.getCards() } returns cards
        every { cardDataSource.newGame() } just Runs
        every { cardDataSource.updateCard(any()) } just Runs
    }
}
