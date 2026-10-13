package com.example.superhero_api.data.datasource.services

import com.example.superhero_api.data.dto.SuperheroDto
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperheroService {

    @GET("all.json")
    suspend fun getAllSuperheroes(): List<SuperheroDto>


    @GET("id/{id}.json")
    suspend fun getSuperheroById(
        @Path("id") id: String
    ): SuperheroDto


}