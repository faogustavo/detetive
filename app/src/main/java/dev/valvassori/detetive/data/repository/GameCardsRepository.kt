package dev.valvassori.detetive.data.repository

import dev.valvassori.detetive.domain.model.GameCard
import kotlinx.coroutines.flow.Flow

interface GameCardsRepository {

    val cardsStream: Flow<List<GameCard>>

    fun newGame()
    fun getCards(): List<GameCard>
    fun updateCard(card: GameCard)
}
