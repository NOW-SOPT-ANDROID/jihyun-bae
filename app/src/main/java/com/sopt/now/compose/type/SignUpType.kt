package com.sopt.now.compose.type

import androidx.annotation.StringRes
import com.sopt.now.compose.R

enum class SignUpType(
    @StringRes val descriptionRes: Int
) {
    ID_ERROR(descriptionRes = R.string.sign_up_id_error),
    PASSWORD_ERROR(descriptionRes = R.string.sign_up_password_error),
    NICKNAME_ERROR(descriptionRes = R.string.sign_up_nickname_error),
    MBTI_ERROR(descriptionRes = R.string.sign_up_mbti_error),
    SUCCESS(descriptionRes = R.string.sign_up_success)
}