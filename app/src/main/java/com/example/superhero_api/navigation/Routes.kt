package com.example.superhero_api.navigation

sealed class Screen (val route: String){
    data object Home : Screen("home")

    data object HeroDetail : Screen("hero_detail/{heroId}"){
        fun createRoute(heroId: String): String{
            return "hero_detail/$heroId"
        }
    }
}