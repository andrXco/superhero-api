package com.example.superhero_api.ui.screens.heroedetail

import com.example.superhero_api.data.model.Superhero

data class HeroDetailState(
    val hero: Superhero? = null,
    val isLoading: Boolean = true,
    val errorMessage: String? = null
)