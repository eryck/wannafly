package com.example.wannafly.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.wannafly.presentation.navigation.WannaFlyNavigator

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination){

        navigation(
            route = Route.WannaFlyNavigation.route,
            startDestination = Route.WannaFlyNavigatorScreen.route
        ) {
            composable(route = Route.WannaFlyNavigatorScreen.route){
                WannaFlyNavigator()
            }
        }
    }
}