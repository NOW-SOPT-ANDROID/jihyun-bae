package com.sopt.now.feature.ui.signup

import androidx.lifecycle.ViewModel
import com.sopt.now.feature.model.UserModel
import com.sopt.now.feature.type.SignUpType

class SignUpViewModel : ViewModel() {
    fun signUp(user: UserModel): SignUpType = when {
        user.id.length !in MIN_ID_LENGTH..MAX_ID_LENGTH -> SignUpType.ID_ERROR
        user.password.length !in MIN_PASSWORD_LENGTH..MAX_PASSWORD_LENGTH -> SignUpType.PASSWORD_ERROR
        user.nickname.isBlank() -> SignUpType.NICKNAME_ERROR
        !user.mbti.matches(MBTI_REGEX) -> SignUpType.MBTI_ERROR
        else -> SignUpType.SUCCESS
    }

    companion object {
        private const val MIN_ID_LENGTH = 6
        private const val MAX_ID_LENGTH = 10
        private const val MIN_PASSWORD_LENGTH = 8
        private const val MAX_PASSWORD_LENGTH = 12
        private const val MBTI_PATTERN = "^[EI][NS][FT][JP]\$"
        private val MBTI_REGEX = Regex(MBTI_PATTERN)
    }

}