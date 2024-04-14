package com.sopt.now.compose.ui.navigator

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.sopt.now.compose.ui.home.navigation.homeNavGraph
import com.sopt.now.compose.ui.signin.navigation.signInNavGraph
import com.sopt.now.compose.ui.signup.navigation.signUpNavGraph

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
                navController = navigator.navHostController
            )

            signInNavGraph(
                navController = navigator.navHostController,
                navigateHome = navigator::navigationHome,
                navigateSignup = navigator::navigationSignUp
            )

            signUpNavGraph(
                navController = navigator.navHostController,
                navigateSignIn = navigator::navigationSignIn
            )
        }
    }
}