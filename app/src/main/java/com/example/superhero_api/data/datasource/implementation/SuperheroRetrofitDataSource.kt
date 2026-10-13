package com.example.superhero_api.data.datasource.implementation

import com.example.superhero_api.data.datasource.SuperheroRemoteDataSource
import com.example.superhero_api.data.datasource.services.SuperheroService
import com.example.superhero_api.data.dto.SuperheroDto
import javax.inject.Inject

class SuperheroRetrofitDataSource @Inject constructor(
    private val service: SuperheroService
): SuperheroRemoteDataSource{

    override suspend fun getAllSuperheroes(): List<SuperheroDto> {
        return service.getAllSuperheroes()
    }

    override suspend fun getSuperheroById(id: String): SuperheroDto {
        return service.getSuperheroById(id)
    }
}