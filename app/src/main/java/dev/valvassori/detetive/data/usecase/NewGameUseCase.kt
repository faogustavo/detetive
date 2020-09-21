package dev.valvassori.detetive.domain.usecases

import dev.valvassori.detetive.data.repository.GameCardsRepository

class NewGameUseCase constructor(
    private val gameCardsRepository: GameCardsRepository,
) {

    operator fun invoke() {
        gameCardsRepository.newGame()
    }
}
