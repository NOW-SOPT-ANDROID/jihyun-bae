package com.sopt.now.compose.ui.signin

import androidx.annotation.StringRes
import com.sopt.now.compose.model.UserModel
import com.sopt.now.compose.util.base.UiEvent
import com.sopt.now.compose.util.base.UiSideEffect
import com.sopt.now.compose.util.base.UiState

class SignInContract {
    data class SignInState(
        val user: UserModel? = null,
        val inputId: String = "",
        val inputPassword: String = ""
    ) : UiState

    sealed interface SignInSideEffect : UiSideEffect {
        data object NavigateToSignUp : SignInSideEffect
        data object PopBackStack : SignInSideEffect
        data class NavigateToHome(val user: UserModel) : SignInSideEffect
        data class ShowToast(@StringRes val message: Int) : SignInSideEffect
    }

    sealed class SignInEvent : UiEvent {
        data object OnSignUpTvClicked : SignInEvent()
        data object OnSignInBtnClicked : SignInEvent()
    }
}