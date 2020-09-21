package dev.valvassori.detetive.data.datasource.impl

import dev.valvassori.detetive.data.datasource.CardDataSource
import dev.valvassori.detetive.data.datasource.generic.HawkDataSource
import dev.valvassori.detetive.domain.factory.GameCardFactory
import dev.valvassori.detetive.domain.model.GameCard
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

@ExperimentalCoroutinesApi
class CardsLocalDataSource constructor(
    private val cache: HawkDataSource<List<GameCard>>,
) : CardDataSource {

    private val _cardsFlow by lazy { MutableStateFlow(getCards()) }

    override val cardsStream: Flow<List<GameCard>>
        get() = _cardsFlow

    override fun getCards(): List<GameCard> = if (cache.exists()) {
        cache.get()
    } else {
        emptyList()
    }

    override fun updateCard(updatedCard: GameCard) {
        val cards = getCards().toMutableList()
        val index = cards.indexOfFirst { it.card == updatedCard.card }

        cards[index] = updatedCard

        cache.set(cards)
        updateCardsFlow()
    }

    override fun newGame() {
        cache.set(GameCardFactory.make())
        updateCardsFlow()
    }

    private fun updateCardsFlow() {
        _cardsFlow.value = getCards()
    }
}
