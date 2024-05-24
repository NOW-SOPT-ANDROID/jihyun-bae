package com.sopt.now.compose.presentation.ui.follower.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.now.compose.presentation.ui.follower.FollowerRoute

fun NavController.navigationFollower(navOptions: NavOptions? = null) {
    navigate(route = FollowerRoute.FOLLOWER, navOptions = navOptions)
}

fun NavGraphBuilder.followerNavGraph() {
    composable(route = FollowerRoute.FOLLOWER) {
        FollowerRoute()
    }
}

object FollowerRoute {
    const val FOLLOWER = "follower"
}