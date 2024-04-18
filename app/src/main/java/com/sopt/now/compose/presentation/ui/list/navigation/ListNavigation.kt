package com.sopt.now.compose.presentation.ui.list.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.now.compose.presentation.ui.list.ListRoute

fun NavController.navigationList(navOptions: NavOptions? = null) {
    navigate(route = ListRoute.ROUTE, navOptions = navOptions)
}

fun NavGraphBuilder.listNavGraph() {
    composable(route = ListRoute.ROUTE) {
        ListRoute()
    }
}

object ListRoute {
    const val ROUTE = "list"
}