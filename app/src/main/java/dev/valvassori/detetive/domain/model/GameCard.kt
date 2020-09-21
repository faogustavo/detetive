package dev.valvassori.detetive.domain.model

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

    val prettyDescription: String
        get() = description?.let { "• $it" }.orEmpty()

    val hasDescription: Boolean
        get() = description != null

    val hasColor: Boolean
        get() = color != null

    val locationColor: Int
        get() = location.color

    val locationText: Int
        get() = location.text
}
