package com.sopt.now.compose.presentation.ui.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sopt.now.compose.presentation.ui.home.HomeRoute

fun NavController.navigationHome() {
    navigate(
        route = HomeRoute.ROUTE
    )
}

fun NavGraphBuilder.homeNavGraph(
    navController: NavController
) {
    composable(route = HomeRoute.ROUTE) {
        HomeRoute(
            navController = navController
        )
    }
}

object HomeRoute {
    const val ROUTE = "home"
}