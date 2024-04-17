package com.sopt.now.compose.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    var id: String,
    val password: String,
    val nickname: String,
    val mbti: String
) : Parcelable