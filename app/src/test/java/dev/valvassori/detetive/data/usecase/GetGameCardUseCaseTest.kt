package dev.valvassori.detetive.data.usecase

import dev.valvassori.detetive.data.repository.GameCardsRepository
import dev.valvassori.detetive.domain.model.Card
import dev.valvassori.detetive.domain.model.GameCard
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class GetGameCardUseCaseTest {
    private val gameCardsRepository: GameCardsRepository = mockk()
    private val subject = GetGameCardUseCase(gameCardsRepository)

    @Test
    fun invoke_getCardsFromRepository() {
        mock()

        subject.invoke(Card.values().random())

        verify { gameCardsRepository.getCards() }
    }

    @Test
    fun invoke_withExistingCard_returnsIt() {
        val card = Card.values().random()
        val expectedResult = GameCard(card = card)
        mock(cards = listOf(expectedResult))

        val result = subject.invoke(card)

        assertEquals(expectedResult, result)
    }

    @Test
    fun invoke_withNotExistingCard_returnsNull() {
        mock(cards = listOf(GameCard(card = Card.CROWBAR)))

        val result = subject.invoke(Card.HOTEL)

        assertNull(result)
    }

    private fun mock(
        cards: List<GameCard> = emptyList(),
    ) {
        every { gameCardsRepository.getCards() } returns cards
    }
}
