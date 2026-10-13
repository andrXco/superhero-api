package com.example.superhero_api.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.superhero_api.data.repository.SuperheroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor( private val repository: SuperheroRepository) : ViewModel(){
    private val _uiState = MutableStateFlow(HomeState())
    val uiState: StateFlow<HomeState> = _uiState

    init {
        loadSuperHeroes()
    }

    fun loadSuperHeroes(){
        viewModelScope.launch {
            _uiState.update { currentState->
                currentState.copy(
                    isLoading = true,
                    errorMessage = null
                )
            }
            repository.getAllSuperheroes().onSuccess {
                superheroes -> _uiState.update {
                    currentState -> currentState.copy(
                        superheroes = superheroes,
                        isLoading = false
                    )
                }
            }
                .onFailure { error ->
                    _uiState.update { currentState -> currentState.copy(
                        isLoading = false,
                        errorMessage = error.message
                    ) }
                }
        }

    }

}