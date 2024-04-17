package com.sopt.now.compose.presentation.ui.signin.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sopt.now.compose.presentation.ui.signin.SignInRoute

fun NavController.navigationSignIn() {
    navigate(
        route = SignInRoute.ROUTE
    ) {
        popBackStack(graph.id, inclusive = true)
    }
}

fun NavGraphBuilder.signInNavGraph(
    navController: NavController,
    popBackStack: () -> Unit,
    navigateHome: () -> Unit = {},
    navigateSignup: () -> Unit = {}
) {
    composable(route = SignInRoute.ROUTE) {
        SignInRoute(
            navController = navController,
            popBackStack = popBackStack,
            navigateToHome = navigateHome,
            navigateToSignUp = navigateSignup
        )
    }
}

object SignInRoute {
    const val ROUTE = "signIn"
}