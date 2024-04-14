package com.sopt.now.compose.ui.signin.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sopt.now.compose.model.UserModel
import com.sopt.now.compose.ui.signin.SignInRoute

fun NavController.navigationSignIn(userModel: UserModel) {
    navigate(
        route = SignInRoute.ROUTE
    ) {
        currentBackStackEntry?.savedStateHandle?.set("user", userModel)
    }
}

fun NavGraphBuilder.signInNavGraph(
    navController: NavController,
    navigateHome: (UserModel) -> Unit = {},
    navigateSignup: () -> Unit = {}
) {
    composable(route = SignInRoute.ROUTE) {
        SignInRoute(
            navController = navController,
            navigateToHome = navigateHome,
            navigateToSignUp = navigateSignup
        )
    }
}

object SignInRoute {
    const val ROUTE = "signIn"
}