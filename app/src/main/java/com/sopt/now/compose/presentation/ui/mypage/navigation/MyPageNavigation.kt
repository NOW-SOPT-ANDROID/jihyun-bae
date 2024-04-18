package com.sopt.now.compose.presentation.ui.mypage.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.now.compose.presentation.ui.mypage.MyPageRoute

fun NavController.navigationMyPage(navOptions: NavOptions? = null) {
    navigate(route = MyPageRoute.ROUTE, navOptions = navOptions)
}

fun NavGraphBuilder.myPageNavGraph(
    navigateToSignIn: () -> Unit = {}
) {
    composable(route = MyPageRoute.ROUTE) {
        MyPageRoute(
            navigateToSignIn = navigateToSignIn
        )
    }
}

object MyPageRoute {
    const val ROUTE = "myPage"
}