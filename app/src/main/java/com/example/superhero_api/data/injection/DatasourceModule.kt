package com.example.superhero_api.data.injection

import androidx.compose.runtime.internal.DecoyImplementation
import com.example.superhero_api.data.datasource.SuperheroRemoteDataSource
import com.example.superhero_api.data.datasource.implementation.SuperheroRetrofitDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DatasourceModule {
    @Binds
    abstract fun binSuperheroRemoteDataSource(
        implementation: SuperheroRetrofitDataSource
    ): SuperheroRemoteDataSource

}