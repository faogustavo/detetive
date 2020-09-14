package dev.valvassori.detective.domain.model

import dev.valvassori.detective.R

enum class Type(val title: Int) {
    WEAPON(R.string.weapon_title),
    CHARACTER(R.string.character_title),
    PLACE(R.string.place_title),
}
