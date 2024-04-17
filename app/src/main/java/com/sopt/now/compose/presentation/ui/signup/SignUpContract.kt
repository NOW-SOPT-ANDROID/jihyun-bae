package com.sopt.now.compose.presentation.ui.signup

import com.sopt.now.compose.presentation.model.UserModel
import com.sopt.now.compose.presentation.type.SignUpType
import com.sopt.now.compose.util.base.UiEvent
import com.sopt.now.compose.util.base.UiSideEffect
import com.sopt.now.compose.util.base.UiState

class SignUpContract {
    data class SignUpState(
        val user: UserModel = UserModel(id = "", password = "", nickname = "", mbti = "")
    ) : UiState

    sealed interface SignUpSideEffect : UiSideEffect {
        data object PopBackStack : SignUpSideEffect
        data class NavigateToSignIn(val userModel: UserModel) : SignUpSideEffect
        data class ShowToast(val signUpType: SignUpType) : SignUpSideEffect
    }

    sealed class SignUpEvent : UiEvent {
        data object OnSignUpBtnClicked : SignUpEvent()
    }
}