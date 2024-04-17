package com.sopt.now.compose.presentation.ui.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sopt.now.compose.presentation.model.UserModel
import com.sopt.now.compose.presentation.ui.home.navigation.navigationHome
import com.sopt.now.compose.presentation.ui.signin.navigation.SignInRoute
import com.sopt.now.compose.presentation.ui.signin.navigation.navigationSignIn
import com.sopt.now.compose.presentation.ui.signup.navigation.navigationSignUp

class MainNavigator(
    val navHostController: NavHostController
) {
    private val currentDestination: NavDestination?
        @Composable get() = navHostController.currentBackStackEntryAsState().value?.destination

    val startDestination = SignInRoute.ROUTE

    fun navigationHome(userModel: UserModel) {
        navHostController.navigationHome(userModel = userModel)
    }

    fun navigationSignIn(userModel: UserModel) {
        navHostController.navigationSignIn(userModel = userModel)
    }

    fun navigationSignUp() {
        navHostController.navigationSignUp()
    }

    fun popBackStack() {
        navHostController.popBackStack()
    }
}

@Composable
fun rememberMainNavigator(
    navHostController: NavHostController = rememberNavController()
): MainNavigator = remember(navHostController) {
    MainNavigator(navHostController = navHostController)
}