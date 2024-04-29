package com.sopt.now.compose.presentation.ui.signup

import com.sopt.now.compose.domain.model.UserEntity
import com.sopt.now.compose.presentation.type.SignUpType
import com.sopt.now.compose.util.base.UiEvent
import com.sopt.now.compose.util.base.UiSideEffect
import com.sopt.now.compose.util.base.UiState

class SignUpContract {
    data class SignUpState(
        val user: UserEntity = UserEntity(id = "", password = "", nickname = "", mbti = "")
    ) : UiState

    sealed interface SignUpSideEffect : UiSideEffect {
        data object PopBackStack : SignUpSideEffect
        data class NavigateToSignIn(val userEntity: UserEntity) : SignUpSideEffect
        data class ShowToast(val signUpType: SignUpType) : SignUpSideEffect
    }

    sealed class SignUpEvent : UiEvent {
        data object OnSignUpBtnClicked : SignUpEvent()
    }
}