package com.sopt.now.compose.ui.signup.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sopt.now.compose.model.UserModel
import com.sopt.now.compose.ui.signup.SignUpRoute

fun NavController.navigationSignUp() {
    navigate(route = SignupRoute.ROUTE)
}

fun NavGraphBuilder.signUpNavGraph(
    navController: NavController,
    navigateSignIn: (UserModel) -> Unit = {}
) {
    composable(route = SignupRoute.ROUTE) {
        SignUpRoute(
            navController = navController,
            navigateToSignIn = navigateSignIn
        )
    }
}

object SignupRoute {
    const val ROUTE = "signup"
}