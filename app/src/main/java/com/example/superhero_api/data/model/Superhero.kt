package com.example.superhero_api.data.model

data class Superhero(
    val id: String,
    val name: String,
    val fullName: String,
    val publisher: String,
    val imageUrl: String,

    val alignment: String,
    val gender: String,
    val race: String,
    val height: String,
    val weight: String,
    val occupation: String,
    val firstApparence: String,

    val powerstats:  SuperheroPowerStats

)

data class SuperheroPowerStats(
    val intelligence: Int?,
    val strength: Int?,
    val speed: Int?,
    val combat: Int?,
    val durability: Int?,
    val power: Int?
)