package dev.valvassori.detetive.data.usecase

import dev.valvassori.detetive.data.repository.GameCardsRepository
import dev.valvassori.detetive.domain.model.GameCard
import dev.valvassori.detetive.factory.GameCardTestFactory
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert.assertEquals
import org.junit.Test

class GetCardsUseCaseTest {

    private val gameCardsRepository: GameCardsRepository = mockk()
    private val subject = GetCardsUseCase(gameCardsRepository)

    @Test
    fun invoke_returnsStream() {
        val data = flowOf(emptyList<GameCard>())
        mock(cardsFlow = data)

        val result = subject.invoke()

        assertEquals(data, result)
    }

    @Test
    fun invoke_withNoRunningGame_createNewGame() {
        mock(gameCards = emptyList())

        subject.invoke()

        verify(exactly = 1) { gameCardsRepository.newGame() }
    }

    @Test
    fun invoke_withRunningGame_doesNotCreateNewGame() {
        mock(gameCards = GameCardTestFactory.runningGameCards())

        subject.invoke()

        verify(exactly = 0) { gameCardsRepository.newGame() }
    }

    private fun mock(
        gameCards: List<GameCard> = emptyList(),
        cardsFlow: Flow<List<GameCard>> = flowOf(emptyList()),
    ) {
        every { gameCardsRepository.newGame() } just Runs
        every { gameCardsRepository.getCards() } returns gameCards
        every { gameCardsRepository.cardsStream } returns cardsFlow
    }
}
