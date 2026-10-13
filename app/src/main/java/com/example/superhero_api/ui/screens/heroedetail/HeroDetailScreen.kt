package com.example.superhero_api.ui.screens.heroedetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.superhero_api.R
import com.example.superhero_api.data.model.Superhero

@Composable
fun HeroDetailScreen(
    heroId: String,
    viewModel : HeroDetailViewModel,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(heroId) {
        viewModel.loadSuperHeroes(
            heroId
        )
    }

    when {
        state.isLoading ->{
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
                TextButton(onClick = onBackClick) {
                    Text(text = stringResource(R.string.back))
                }
            }
        }
        state.hero != null -> {
            HeroeDetailContent(
                hero = state.hero!!,
                onBackClick = onBackClick,
                modifier = modifier
            )
        }
    }

}
@Composable
private fun HeroeDetailContent(
    hero : Superhero,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
){
   LazyColumn(
       modifier = modifier.fillMaxSize(),
       contentPadding = PaddingValues(17.dp),
       verticalArrangement = Arrangement.spacedBy(12.dp)
   ) {
       item {
           TextButton(onClick = onBackClick) {
               Text(text = stringResource(R.string.back))
           }
       }
       item {
           AsyncImage(
               model = hero.imageUrl,
               contentDescription = hero.name,
               modifier = Modifier.fillMaxWidth().height(360.dp),
               contentScale = ContentScale.Fit
           )
       }
       item{
           Text(
               text = hero.name,
               style = MaterialTheme.typography.headlineMedium
           )
           Text(
               text = stringResource(R.string.hero_full_name, hero.fullName)
           )
           Text(
               text = stringResource(R.string.hero_publisher, hero.publisher)
           )
           Text(
               text = stringResource(R.string.hero_alignment, hero.alignment)
           )
           Text(
               text = stringResource(R.string.hero_occupation, hero.occupation)
           )
           Text(
               text = stringResource(R.string.hero_first_appearance, hero.firstApparence)
           )
           Text(
               text = stringResource(R.string.hero_gender, hero.gender)
           )
           Text(
               text = stringResource(R.string.hero_race, hero.race)
           )
           Text(
               text = stringResource(R.string.hero_height, hero.height)
           )
           Text(
               text = stringResource(R.string.hero_weight, hero.weight)
           )

           Text(
               text = stringResource(R.string.hero_intelligence, hero.powerstats.intelligence ?: 0)
           )
           Text(
               text = stringResource(R.string.hero_strength, hero.powerstats.strength ?: 0)
           )
       }
   }
}

