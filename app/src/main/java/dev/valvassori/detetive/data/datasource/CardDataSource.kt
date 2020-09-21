package dev.valvassori.detetive.data.datasource

import dev.valvassori.detetive.domain.model.GameCard
import kotlinx.coroutines.flow.Flow

interface CardDataSource {
    val cardsStream: Flow<List<GameCard>>

    fun newGame()
    fun getCards(): List<GameCard>
    fun updateCard(updatedCard: GameCard)
}
