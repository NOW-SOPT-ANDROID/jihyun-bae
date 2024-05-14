package com.sopt.now.compose.data.datasource.local

interface SoptLocalDataSource {
    var isLogin: Boolean
    var userId: Int
    fun clear()
}