package com.sopt.now.compose.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    val id: String,
    val password: String,
    val nickname: String,
    val mbti: String
): Parcelable