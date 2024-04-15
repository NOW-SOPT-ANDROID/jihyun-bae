package com.sopt.now.feature.type

import androidx.annotation.StringRes

enum class SignUpType(
    @StringRes val descriptionRes: Int
) {
    ID_ERROR(descriptionRes = org.sopt.now.designsystem.R.string.sign_up_id_error),
    PASSWORD_ERROR(descriptionRes = org.sopt.now.designsystem.R.string.sign_up_password_error),
    NICKNAME_ERROR(descriptionRes = org.sopt.now.designsystem.R.string.sign_up_nickname_error),
    MBTI_ERROR(descriptionRes = org.sopt.now.designsystem.R.string.sign_up_mbti_error),
    SUCCESS(descriptionRes = org.sopt.now.designsystem.R.string.sign_up_success)
}