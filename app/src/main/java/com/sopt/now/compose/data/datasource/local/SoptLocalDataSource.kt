package com.sopt.now.compose.data.datasource.local

import com.sopt.now.compose.data.model.local.User

interface SoptLocalDataSource {
    var isLogin: Boolean
    var userId: Int
    fun clear()
}