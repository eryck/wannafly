package com.example.wannafly.presentation.navgraph

sealed class Route(
    val route: String
){
    object HomeScreen : Route(route = "homeScreen")
    object FavoriteScreen : Route(route = "FavoriteScreen")
    object UserScreen : Route(route = "UserScreen")
    object WannaFlyNavigation : Route(route = "WannaFlyNavigation")
    object WannaFlyNavigatorScreen : Route(route = "WannaFlyNavigator")
}
