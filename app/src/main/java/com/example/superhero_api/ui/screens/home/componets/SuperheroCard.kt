package com.example.superhero_api.ui.screens.home.componets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import com.example.superhero_api.data.model.Superhero
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superhero_api.R
import coil3.compose.AsyncImage
import com.example.superhero_api.data.model.SuperheroPowerStats
import com.example.superhero_api.ui.theme.Superhero_apiTheme
import org.jetbrains.annotations.Async

@Composable
fun SuperheroCard(
    hero: Superhero,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = hero.imageUrl,
                contentDescription = hero.name,
                modifier = Modifier.size(width = 90.dp, height = 120.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.weight(1f).padding(start = 12.dp)
            ) {
                Text(text = hero.name)
                Text(
                    text = stringResource(
                        R.string.hero_full_name,
                        hero.fullName
                    )
                )

                Text(
                    text = stringResource(
                        R.string.hero_publisher,
                        hero.publisher
                    )
                )
            }


        }

    }
}
