package com.example.superhero_api.ui.screens.home

import android.os.Message
import com.example.superhero_api.data.model.Superhero

data class HomeState(
    val superheroes: List<Superhero> = emptyList(),
    val isLoading: Boolean = true,
    val errorMessage: String? = null)
