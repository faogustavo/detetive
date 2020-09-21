package dev.valvassori.detetive.domain.usecases

import dev.valvassori.detetive.data.repository.GameCardsRepository
import dev.valvassori.detetive.domain.model.GameCard

class UpdateCardUseCase constructor(
    private val gameCardsRepository: GameCardsRepository,
) {

    operator fun invoke(card: GameCard) {
        gameCardsRepository.updateCard(card)
    }
}
