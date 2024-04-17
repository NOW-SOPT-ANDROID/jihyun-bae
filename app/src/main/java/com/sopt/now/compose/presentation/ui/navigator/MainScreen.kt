package com.sopt.now.compose.presentation.ui.navigator

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.sopt.now.compose.presentation.ui.home.navigation.homeNavGraph
import com.sopt.now.compose.presentation.ui.signin.navigation.signInNavGraph
import com.sopt.now.compose.presentation.ui.signup.navigation.signUpNavGraph

@Composable
fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator()
) {
    Scaffold { innerPadding ->
        NavHost(
            navController = navigator.navHostController,
            startDestination = navigator.startDestination,
            modifier = Modifier.padding(innerPadding)
        ) {
            homeNavGraph(
                navController = navigator.navHostController,
                navigateToSignIn = navigator::navigationSignIn
            )

            signInNavGraph(
                navController = navigator.navHostController,
                popBackStack = navigator::popBackStack,
                navigateHome = navigator::navigationHome,
                navigateSignup = navigator::navigationSignUp
            )

            signUpNavGraph(
                navController = navigator.navHostController,
                popBackStack = navigator::popBackStack,
                navigateSignIn = navigator::navigationSignIn
            )
        }
    }
}