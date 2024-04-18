package com.sopt.now.compose.presentation.ui.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import com.sopt.now.compose.presentation.ui.home.HomeRoute

fun NavController.navigationHome(
    navOptions: NavOptions? = null
) {
    navigate(
        route = HomeRoute.ROUTE,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.homeNavGraph() {
    composable(route = HomeRoute.ROUTE) {
        HomeRoute()
    }
}

object HomeRoute {
    const val ROUTE = "home"
}