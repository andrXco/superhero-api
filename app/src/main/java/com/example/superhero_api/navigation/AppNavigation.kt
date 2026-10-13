package com.example.superhero_api.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.superhero_api.ui.screens.heroedetail.HeroDetailScreen
import com.example.superhero_api.ui.screens.heroedetail.HeroDetailViewModel
import com.example.superhero_api.ui.screens.home.HomeScreen
import com.example.superhero_api.ui.screens.home.HomeViewModel

@Composable
fun AppNavegation(
    modifier: Modifier = Modifier
){
    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route){
            val viewModel: HomeViewModel = hiltViewModel()

            HomeScreen(
                viewModel = viewModel,
                onHeroClick = { heroId ->
                    navController.navigate(
                        Screen.HeroDetail.createRoute(heroId)
                    )
                }
            )
        }
        composable(
            route = Screen.HeroDetail.route,
            arguments  = listOf(
                navArgument("heroId"){
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            // Lee el ID que Home agregó a la ruta.
            val heroId = backStackEntry.arguments
                ?.getString("heroId")
                ?: return@composable

            val viewModel: HeroDetailViewModel = hiltViewModel()

            HeroDetailScreen(
                heroId = heroId,
                viewModel = viewModel,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
