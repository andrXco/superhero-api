package com.example.superhero_api.data.injection

import com.example.superhero_api.data.datasource.services.SuperheroService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideGson(): Gson{
        return GsonBuilder().create()
    }
    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://akabab.github.io/superhero-api/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
    @Provides
    @Singleton
    fun provideSuperheroService(retrofit: Retrofit): SuperheroService{
        return retrofit.create(SuperheroService::class.java)
    }
}