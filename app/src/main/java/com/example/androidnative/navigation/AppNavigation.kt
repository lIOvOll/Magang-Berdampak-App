package com.example.androidnative.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.androidnative.ui.screens.Screen1
import com.example.androidnative.ui.screens.Screen2
import com.example.androidnative.ui.screens.Screen3


@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "screen1") {
        composable("screen1") {
            Screen1(onNextClick = { name ->
                navController.navigate("screen2/$name")
            })
        }
        composable(
            route = "screen2/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            Screen2(name = name, navController = navController)
        }
        composable("screen3") {
            Screen3(navController = navController)
        }
    }
}