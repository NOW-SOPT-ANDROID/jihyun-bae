package com.sopt.now.compose.presentation.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sopt.now.compose.R

enum class DialogType(
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
    @StringRes val description: Int,
    @StringRes val leftBtnText: Int,
    @StringRes val rightBtnText: Int
) {
    LOGOUT(
        icon = R.drawable.ic_sad_24,
        title = R.string.logout,
        description = R.string.logout_description,
        leftBtnText = R.string.dialog_yes,
        rightBtnText = R.string.dialog_no
    ),
    DELETE_PROFILE(
        icon = R.drawable.ic_sad_24,
        title = R.string.delete_profile,
        description = R.string.delete_profile_description,
        leftBtnText = R.string.dialog_yes,
        rightBtnText = R.string.dialog_no
    )
}