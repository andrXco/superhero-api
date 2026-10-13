package com.example.superhero_api.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.superhero_api.R
import com.example.superhero_api.ui.screens.home.componets.SuperheroCard

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onHeroClick : (String) -> Unit,
    modifier: Modifier = Modifier
) {

    val state by viewModel.uiState.collectAsState()

    HomeContent(
        state = state,
        onHeroClick = onHeroClick,
        onRetry = viewModel::loadSuperHeroes,
        modifier = modifier
    )
}
    @Composable
    private fun HomeContent(
        state: HomeState,
        onHeroClick: (String) -> Unit,
        onRetry: () -> Unit,
        modifier: Modifier = Modifier
    ){
        when{
            state.isLoading -> {
                Box(
                    modifier = modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    CircularProgressIndicator()
                }
            }
            state.errorMessage != null -> {
                Column(
                    modifier = modifier.fillMaxSize().padding(23.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = state.errorMessage?: stringResource(R.string.generic_error)
                    )

                    Button(onClick = onRetry) {
                        Text(text = stringResource(R.string.retry))
                    }
                }
            }

            else -> {
                LazyColumn(
                    modifier = modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    items(
                        items = state.superheroes,
                        key = { hero -> hero.id}
                    ){
                        hero ->
                        SuperheroCard(
                            hero = hero,
                            onClick = {onHeroClick(hero.id)}
                        )
                    }



                }
            }
        }
    }

