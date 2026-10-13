package com.example.superhero_api.ui.screens.heroedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superhero_api.data.repository.SuperheroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroDetailViewModel @Inject constructor( private val repository: SuperheroRepository) : ViewModel(){
    private val _uiState = MutableStateFlow(HeroDetailState())
    val uiState: StateFlow<HeroDetailState> = _uiState

    fun loadSuperHeroes(id: String){
        viewModelScope.launch {
            _uiState.update { currentState->
                currentState.copy(
                    isLoading = true,
                    errorMessage = null
                )
            }
            repository.getSuperheroById(id).onSuccess {
                    hero -> _uiState.update {
                    currentState -> currentState.copy(
                hero = hero,
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