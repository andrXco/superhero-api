package com.example.superhero_api.data.datasource

import com.example.superhero_api.data.dto.SuperheroDto
import com.example.superhero_api.data.model.Superhero

interface SuperheroRemoteDataSource {

    suspend fun getAllSuperheroes(): List<SuperheroDto>

    suspend fun getSuperheroById(id: String): SuperheroDto
}