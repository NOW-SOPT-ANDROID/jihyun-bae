package com.sopt.now.compose.presentation.ui.signup.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sopt.now.compose.presentation.model.UserModel
import com.sopt.now.compose.presentation.ui.signup.SignUpRoute

fun NavController.navigationSignUp() {
    navigate(route = SignupRoute.ROUTE)
}

fun NavGraphBuilder.signUpNavGraph(
    navController: NavController,
    popBackStack: () -> Unit,
    navigateSignIn: (UserModel) -> Unit = {}
) {
    composable(route = SignupRoute.ROUTE) {
        SignUpRoute(
            navController = navController,
            popBackStack = popBackStack,
            navigateToSignIn = navigateSignIn
        )
    }
}

object SignupRoute {
    const val ROUTE = "signup"
}