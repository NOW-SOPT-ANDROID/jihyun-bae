package com.sopt.now.compose.presentation.ui.signin

import com.sopt.now.compose.util.base.UiEvent
import com.sopt.now.compose.util.base.UiSideEffect
import com.sopt.now.compose.util.base.UiState

class SignInContract {
    data class SignInState(
        val inputId: String = "",
        val inputPassword: String = ""
    ) : UiState

    sealed interface SignInSideEffect : UiSideEffect {
        data object NavigateToSignUp : SignInSideEffect
        data object PopBackStack : SignInSideEffect
        data object NavigateToHome : SignInSideEffect
        data class ShowToast(val message: String) : SignInSideEffect
    }

    sealed class SignInEvent : UiEvent {
        data object OnSignUpTvClicked : SignInEvent()
        data object OnSignInBtnClicked : SignInEvent()
    }
}