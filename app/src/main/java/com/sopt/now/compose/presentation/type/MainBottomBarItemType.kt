package com.sopt.now.compose.presentation.type

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.sopt.now.compose.R
import com.sopt.now.compose.presentation.ui.follower.navigation.FollowerRoute
import com.sopt.now.compose.presentation.ui.list.navigation.ListRoute
import com.sopt.now.compose.presentation.ui.mypage.navigation.MyPageRoute

enum class MainBottomBarItemType(
    val icon: ImageVector,
    @StringRes val label: Int,
    val route: String
) {
    HOME(
        icon = Icons.Filled.Home,
        label = R.string.main_navigation_item_home,
        route = FollowerRoute.FOLLOWER
    ),
    LIST(
        icon = Icons.Filled.Menu,
        label = R.string.main_navigation_item_list,
        route = ListRoute.ROUTE
    ),
    MyPage(
        icon = Icons.Filled.Person,
        label = R.string.main_navigation_item_my_page,
        route = MyPageRoute.ROUTE
    );

    companion object {
        operator fun contains(route: String) =
            entries.map { mainNavigationItemType -> mainNavigationItemType.route }.contains(route)

        fun find(route: String): MainBottomBarItemType? =
            entries.find { mainNavigationItemType -> mainNavigationItemType.route == route }
    }
}