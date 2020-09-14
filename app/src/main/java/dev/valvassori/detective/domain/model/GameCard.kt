package dev.valvassori.detective.domain.model

import androidx.annotation.VisibleForTesting

data class GameCard(
    val location: Location = Location.UNKNOWN,
    val description: String? = null,
    @VisibleForTesting() val card: Card,
) {
    val name: Int
        get() = card.cardName

    val color: Int?
        get() = card.color

    val type: Type
        get() = card.type

    fun areItemsTheSame(other: GameCard): Boolean =
        card == other.card

    fun areContentSame(other: GameCard): Boolean =
        card == other.card && location == other.location && description == other.description
}
