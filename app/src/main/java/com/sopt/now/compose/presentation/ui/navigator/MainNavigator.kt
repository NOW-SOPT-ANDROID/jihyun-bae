package com.sopt.now.compose.presentation.ui.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.sopt.now.compose.presentation.type.MainBottomBarItemType
import com.sopt.now.compose.presentation.ui.follower.navigation.navigationFollower
import com.sopt.now.compose.presentation.ui.home.navigation.navigationHome
import com.sopt.now.compose.presentation.ui.list.navigation.navigationList
import com.sopt.now.compose.presentation.ui.mypage.navigation.navigationMyPage
import com.sopt.now.compose.presentation.ui.signin.navigation.SignInRoute
import com.sopt.now.compose.presentation.ui.signin.navigation.navigationSignIn
import com.sopt.now.compose.presentation.ui.signup.navigation.navigationSignUp

class MainNavigator(
    val navHostController: NavHostController
) {
    private val currentDestination: NavDestination?
        @Composable get() = navHostController.currentBackStackEntryAsState().value?.destination

    val startDestination = SignInRoute.ROUTE

    val currentMainNavigationItem: MainBottomBarItemType?
        @Composable get() = currentDestination?.route?.let(MainBottomBarItemType::find)

    fun navigateMainNavigation(mainBottomBarItemType: MainBottomBarItemType) {
        navOptions {
            popBackStack()
            launchSingleTop = true
            restoreState = true
        }.let { navOptions ->
            popBackStack()
            when (mainBottomBarItemType) {
                MainBottomBarItemType.HOME -> navHostController.navigationFollower(navOptions = navOptions)
                MainBottomBarItemType.LIST -> navHostController.navigationList(navOptions = navOptions)
                MainBottomBarItemType.MyPage -> navHostController.navigationMyPage(navOptions = navOptions)
            }
        }
    }

    fun navigationHome(navOptions: NavOptions) {
        navHostController.navigationHome(navOptions = navOptions)
    }

    fun navigationFollower(navOptions: NavOptions) {
        navHostController.navigationFollower(navOptions = navOptions)
    }

    fun navigationList() {
        navHostController.navigationList()
    }

    fun navigationMyPage() {
        navHostController.navigationMyPage()
    }

    fun navigationSignIn() {
        navHostController.navigationSignIn()
    }

    fun navigationSignUp() {
        navHostController.navigationSignUp()
    }

    fun popBackStack() {
        navHostController.popBackStack()
    }

    @Composable
    fun showBottomBar(): Boolean =
        currentDestination?.route?.let { currentRoute -> currentRoute in MainBottomBarItemType }
            ?: false
}

@Composable
fun rememberMainNavigator(
    navHostController: NavHostController = rememberNavController()
): MainNavigator = remember(navHostController) {
    MainNavigator(navHostController = navHostController)
}