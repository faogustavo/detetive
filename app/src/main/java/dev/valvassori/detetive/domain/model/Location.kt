package dev.valvassori.detetive.domain.model

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import dev.valvassori.detetive.R

enum class Location(
    @ColorRes val color: Int,
    @StringRes val shortText: Int,
    @StringRes val text: Int,
) {
    HAND(
        color = R.color.location_hand,
        shortText = R.string.caption_location_hand_short,
        text = R.string.caption_location_hand,
    ),
    ENVELOP(
        color = R.color.location_envelop,
        shortText = R.string.caption_location_envelop_short,
        text = R.string.caption_location_envelop,
    ),
    MAYBE_HAND(
        color = R.color.location_maybe_hand,
        shortText = R.string.caption_location_maybe_hand_short,
        text = R.string.caption_location_maybe_hand,
    ),
    MAYBE_ENVELOP(
        color = R.color.location_maybe_envelop,
        shortText = R.string.caption_location_maybe_envelop_short,
        text = R.string.caption_location_maybe_envelop,
    ),
    UNKNOWN(
        color = R.color.location_unknown,
        shortText = R.string.caption_location_unknown_short,
        text = R.string.caption_location_unknown,
    ),
}
