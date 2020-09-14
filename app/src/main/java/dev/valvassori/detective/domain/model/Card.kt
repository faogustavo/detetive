package dev.valvassori.detective.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import dev.valvassori.detective.R

enum class Card(
    @StringRes val cardName: Int,
    @DrawableRes val color: Int?,
    val type: Type,
) {
    // Characters
    SERGEANT(R.string.card_sergeant, R.color.card_sergeant, Type.CHARACTER),
    FLORIST(R.string.card_florist, R.color.card_florist, Type.CHARACTER),
    CHEF(R.string.card_sergeant, R.color.card_sergeant, Type.CHARACTER),
    BUTLER(R.string.card_butler, R.color.card_butler, Type.CHARACTER),
    DOCTOR(R.string.card_doctor, R.color.card_doctor, Type.CHARACTER),
    DANCER(R.string.card_dancer, R.color.card_dancer, Type.CHARACTER),
    GRAVEDIGGER(R.string.card_gravedigger, R.color.card_gravedigger, Type.CHARACTER),
    LAWYER(R.string.card_lawyer, R.color.card_lawyer, Type.CHARACTER),

    // Weapons
    CROWBAR(R.string.card_crowbar, null, Type.WEAPON),
    KNIFE(R.string.card_knife, null, Type.WEAPON),
    SCISSORS(R.string.card_scissors, null, Type.WEAPON),
    SHOTGUN(R.string.card_shotgun, null, Type.WEAPON),
    POISON(R.string.card_poison, null, Type.WEAPON),
    CHEMICAL_WEAPON(R.string.card_chemical_weapon, null, Type.WEAPON),
    KNUCLE(R.string.card_knuckle, null, Type.WEAPON),
    SHOVEL(R.string.card_shovel, null, Type.WEAPON),

    // Places,
    MASION(R.string.card_mansion, null, Type.PLACE),
    HOSPITAL(R.string.card_hospital, null, Type.PLACE),
    TRAIN_STATION(R.string.card_train_station, null, Type.PLACE),
    GRAVEYARD(R.string.card_graveyard, null, Type.PLACE),
    BANK(R.string.card_bank, null, Type.PLACE),
    CENTRAL_PARK(R.string.card_central_park, null, Type.PLACE),
    RESTAURANT(R.string.card_restaurant, null, Type.PLACE),
    FLOWER_SHOP(R.string.card_flower_shop, null, Type.PLACE),
    CITY_HALL(R.string.card_city_hall, null, Type.PLACE),
    NIGHTCLUB(R.string.card_nightclub, null, Type.PLACE),
    HOTEL(R.string.card_hotel, null, Type.PLACE),
}
