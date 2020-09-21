package dev.valvassori.detetive.data.usecase

import dev.valvassori.detetive.data.repository.GameCardsRepository
import dev.valvassori.detetive.domain.model.GameCard
import kotlinx.coroutines.flow.Flow

class GetCardsUseCase constructor(
    private val gameCardsRepository: GameCardsRepository,
) {

    operator fun invoke(): Flow<List<GameCard>> {
        if (gameCardsRepository.getCards().isEmpty()) {
            gameCardsRepository.newGame()
        }

        return gameCardsRepository.cardsStream
    }
}
