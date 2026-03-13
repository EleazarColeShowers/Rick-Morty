package com.example.rickandmorty.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rickandmorty.ui.detail.CharacterDetailScreen
import com.example.rickandmorty.ui.list.CharacterListScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "character_list") {
        composable("character_list") {
            CharacterListScreen(
                onCharacterClick = { id ->
                    navController.navigate("character_detail/$id")
                }
            )
        }
        composable(
            route = "character_detail/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStack ->
            val id = backStack.arguments?.getInt("id") ?: return@composable
             CharacterDetailScreen(id = id, onBack = { navController.popBackStack() })
        }
    }
}