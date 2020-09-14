package dev.valvassori.detective.domain.model

import dev.valvassori.detective.R

enum class Location(val color: Int) {
    HAND(R.color.location_hand),
    ENVELOP(R.color.location_envelop),
    MAYBE_HAND(R.color.location_maybe_hand),
    MAYBE_ENVELOP(R.color.location_maybe_envelop),
    UNKNOWN(R.color.location_unknown),
}
