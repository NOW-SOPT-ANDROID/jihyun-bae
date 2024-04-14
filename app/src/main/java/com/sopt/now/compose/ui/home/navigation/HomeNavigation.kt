package com.sopt.now.compose.ui.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sopt.now.compose.model.UserModel
import com.sopt.now.compose.ui.home.HomeRoute
import com.sopt.now.compose.ui.signin.navigation.SignInRoute

fun NavController.navigationHome(userModel: UserModel) {
    navigate(
        route = HomeRoute.ROUTE
    ) {
        currentBackStackEntry?.savedStateHandle?.set("user", userModel)
    }
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