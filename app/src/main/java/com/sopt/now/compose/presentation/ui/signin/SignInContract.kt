package com.sopt.now.compose.presentation.ui.signin

import androidx.annotation.StringRes
import com.sopt.now.compose.domain.model.UserEntity
import com.sopt.now.compose.util.base.UiEvent
import com.sopt.now.compose.util.base.UiSideEffect
import com.sopt.now.compose.util.base.UiState

class SignInContract {
    data class SignInState(
        val user: UserEntity? = null,
        val inputId: String = "",
        val inputPassword: String = ""
    ) : UiState

    sealed interface SignInSideEffect : UiSideEffect {
        data object NavigateToSignUp : SignInSideEffect
        data object PopBackStack : SignInSideEffect
        data object NavigateToHome : SignInSideEffect
        data class ShowToast(@StringRes val message: Int) : SignInSideEffect
    }

    sealed class SignInEvent : UiEvent {
        data object OnSignUpTvClicked : SignInEvent()
        data object OnSignInBtnClicked : SignInEvent()
    }
}