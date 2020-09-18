package dev.valvassori.detetive.domain.model

import dev.valvassori.detetive.R

enum class Type(val title: Int) {
    WEAPON(R.string.weapon_title),
    CHARACTER(R.string.character_title),
    PLACE(R.string.place_title),
}
