package com.sopt.now.compose.presentation.ui.signup

import com.sopt.now.compose.domain.model.SoptUserModel
import com.sopt.now.compose.util.base.UiEvent
import com.sopt.now.compose.util.base.UiSideEffect
import com.sopt.now.compose.util.base.UiState

class SignUpContract {
    data class SignUpState(
        val user: SoptUserModel = SoptUserModel(),
        val userId: Int? = null
    ) : UiState

    sealed interface SignUpSideEffect : UiSideEffect {
        data object PopBackStack : SignUpSideEffect
        data object NavigateToSignIn : SignUpSideEffect
        data class ShowToast(val message: String) : SignUpSideEffect
    }

    sealed class SignUpEvent : UiEvent {
        data object OnSignUpBtnClicked : SignUpEvent()
    }
}