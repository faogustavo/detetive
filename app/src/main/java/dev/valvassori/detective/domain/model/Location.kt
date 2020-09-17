package dev.valvassori.detective.domain.model

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import dev.valvassori.detective.R

enum class Location(
    @ColorRes val color: Int,
    @StringRes val text: Int
) {
    HAND(R.color.location_hand, R.string.caption_location_hand),
    ENVELOP(R.color.location_envelop, R.string.caption_location_envelop),
    MAYBE_HAND(R.color.location_maybe_hand, R.string.caption_location_maybe_hand),
    MAYBE_ENVELOP(R.color.location_maybe_envelop, R.string.caption_location_maybe_envelop),
    UNKNOWN(R.color.location_unknown, R.string.caption_location_unknown),
}
