package com.example.superhero_api.data.dto

import com.example.superhero_api.data.model.Superhero
import com.example.superhero_api.data.model.SuperheroPowerStats

data class SuperheroDto(
    val id: Int,
    val name : String,
    val slug: String,
    val powerstats: PowerstatsDto,
    val biography: BiographyDto,
    val appearance: ApparenceDto,
    val work: WorkDto,
    val images: ImagesDto
)
data class PowerstatsDto(
    val intelligence: Int,
    val strength: Int?,
    val speed: Int?,
    val combat: Int?,
    val durability: Int?,
    val power: Int?,
)
data class BiographyDto(
    val fullName: String?,
    val publisher: String?,
    val alignment: String?,
    val firstAppearance: String,
    )
data class ApparenceDto(
    val gender: String,
    val race: String?,
    val height: List<String>,
    val weight: List<String>
)

data class WorkDto(
    val occupation : String
)
data class ImagesDto(
    val md: String?,
    val lg: String?
)

fun SuperheroDto.toSuperhero(): Superhero {
    return Superhero(
        id = id.toString(),
        name = name,
        fullName = biography.fullName ?: "",
        publisher = biography.publisher ?: "",
        alignment = biography.alignment ?: "",

        imageUrl = images.lg ?: images.md ?: "",

        gender = appearance.gender,
        race = appearance.race.orEmpty(),

        height = appearance.height.firstOrNull().orEmpty(),
        weight = appearance.weight.firstOrNull().orEmpty(),

        occupation = work.occupation,
        firstApparence = biography.firstAppearance,


        powerstats = SuperheroPowerStats(
            intelligence = powerstats.intelligence,
            strength = powerstats.strength,
            speed = powerstats.speed,
            combat = powerstats.combat,
            durability = powerstats.durability,
            power = powerstats.power
        )

    )
}

