package com.sopt.now.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import org.sopt.now.designsystem.R

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
    )
}