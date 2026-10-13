package com.example.superhero_api

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.superhero_api.navigation.AppNavegation
import com.example.superhero_api.ui.theme.Superhero_apiTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                Superhero_apiTheme {
                    Scaffold(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        innerPadding ->
                        AppNavegation(
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
        }
    }
}
