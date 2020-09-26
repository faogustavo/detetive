package dev.valvassori.detetive.data.usecase

import dev.valvassori.detetive.data.repository.GameCardsRepository
import dev.valvassori.detetive.domain.model.Card
import dev.valvassori.detetive.domain.model.GameCard

class GetGameCardUseCase constructor(
    private val gameCardsRepository: GameCardsRepository,
) {

    operator fun invoke(card: Card): GameCard? =
        gameCardsRepository.getCards().find { it.card == card }
}
