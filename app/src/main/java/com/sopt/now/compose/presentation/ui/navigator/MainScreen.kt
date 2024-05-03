package com.sopt.now.compose.presentation.ui.navigator

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import com.sopt.now.compose.presentation.type.MainBottomBarItemType
import com.sopt.now.compose.presentation.ui.follower.navigation.followerNavGraph
import com.sopt.now.compose.presentation.ui.home.navigation.homeNavGraph
import com.sopt.now.compose.presentation.ui.list.navigation.listNavGraph
import com.sopt.now.compose.presentation.ui.mypage.navigation.myPageNavGraph
import com.sopt.now.compose.presentation.ui.signin.navigation.signInNavGraph
import com.sopt.now.compose.presentation.ui.signup.navigation.signUpNavGraph

@Composable
fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator()
) {
    Scaffold(
        bottomBar = {
            MainBottomBar(
                isVisible = navigator.showBottomBar(),
                menus = MainBottomBarItemType.entries.toList(),
                currentMenu = navigator.currentMainNavigationItem,
                onMenuSelected = navigator::navigateMainNavigation
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navigator.navHostController,
            startDestination = navigator.startDestination,
            modifier = Modifier.padding(innerPadding)
        ) {
            homeNavGraph()

            followerNavGraph()

            listNavGraph()

            myPageNavGraph(
                navigateToSignIn = navigator::navigationSignIn
            )

            signInNavGraph(
                navController = navigator.navHostController,
                popBackStack = navigator::popBackStack,
                navigateHome = navigator::navigationFollower,
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

@Composable
private fun MainBottomBar(
    isVisible: Boolean,
    menus: List<MainBottomBarItemType>,
    currentMenu: MainBottomBarItemType?,
    onMenuSelected: (MainBottomBarItemType) -> Unit
) {
    val context = LocalContext.current
    AnimatedVisibility(visible = isVisible) {
        NavigationBar {
            menus.forEachIndexed { _, mainBottomBarItemType ->
                NavigationBarItem(
                    selected = currentMenu == mainBottomBarItemType,
                    onClick = { onMenuSelected(mainBottomBarItemType) },
                    icon = {
                        Icon(
                            mainBottomBarItemType.icon,
                            contentDescription = context.getString(mainBottomBarItemType.label)
                        )
                    },
                    label = { Text(text = context.getString(mainBottomBarItemType.label)) }
                )
            }
        }
    }
}