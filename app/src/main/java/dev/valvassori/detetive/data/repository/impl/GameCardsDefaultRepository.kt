package dev.valvassori.detetive.data.repository.impl

import dev.valvassori.detetive.data.datasource.CardDataSource
import dev.valvassori.detetive.data.repository.GameCardsRepository
import dev.valvassori.detetive.domain.model.GameCard
import kotlinx.coroutines.flow.Flow

class GameCardsDefaultRepository constructor(
    private val cardDataSource: CardDataSource,
) : GameCardsRepository {

    override val cardsStream: Flow<List<GameCard>>
        get() = cardDataSource.cardsStream

    override fun newGame() =
        cardDataSource.newGame()

    override fun getCards(): List<GameCard> =
        cardDataSource.getCards()

    override fun updateCard(card: GameCard) =
        cardDataSource.updateCard(card)
}
