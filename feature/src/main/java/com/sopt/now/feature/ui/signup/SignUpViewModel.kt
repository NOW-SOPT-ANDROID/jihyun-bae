package com.sopt.now.feature.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.now.domain.model.UserEntity
import com.sopt.now.domain.repository.SoptRepository
import com.sopt.now.feature.type.SignUpType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val soptRepository: SoptRepository
) : ViewModel() {
    private fun saveUserInfo(userEntity: UserEntity) {
        viewModelScope.launch {
            soptRepository.setUser(userEntity = userEntity)
        }
    }

    fun signUp(userEntity: UserEntity): SignUpType = when {
        userEntity.id.length !in MIN_ID_LENGTH..MAX_ID_LENGTH -> SignUpType.ID_ERROR
        userEntity.password.length !in MIN_PASSWORD_LENGTH..MAX_PASSWORD_LENGTH -> SignUpType.PASSWORD_ERROR
        userEntity.nickname.isBlank() -> SignUpType.NICKNAME_ERROR
        !userEntity.mbti.matches(MBTI_REGEX) -> SignUpType.MBTI_ERROR
        else -> {
            saveUserInfo(userEntity = userEntity)
            SignUpType.SUCCESS
        }
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