package com.example.superhero_api.data.repository

import com.example.superhero_api.data.datasource.SuperheroRemoteDataSource
import com.example.superhero_api.data.dto.toSuperhero
import com.example.superhero_api.data.model.Superhero
import javax.inject.Inject

class SuperheroRepository @Inject constructor(
    private val remoteDataSource: SuperheroRemoteDataSource
) {
    suspend fun getAllSuperheroes (): Result<List<Superhero>>{

       return try {
           val superheroDto = remoteDataSource.getAllSuperheroes()
           val superheroes = superheroDto.map {
                   dto -> dto.toSuperhero()
           }
           Result.success(superheroes)
       }catch (exception: Exception) {
           Result.failure(exception)
       }
    }

    suspend fun getSuperheroById(id: String): Result<Superhero>{
        return try {
            val superheroDto = remoteDataSource.getSuperheroById(id)
            val superhero = superheroDto.toSuperhero()
            Result.success(superhero)
        }catch (exception : Exception){
            Result.failure(exception)
        }

    }

}