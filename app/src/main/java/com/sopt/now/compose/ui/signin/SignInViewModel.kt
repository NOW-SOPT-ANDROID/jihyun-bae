package com.sopt.now.compose.ui.signin

import com.sopt.now.compose.R
import com.sopt.now.compose.model.UserModel
import com.sopt.now.compose.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor() :
    BaseViewModel<SignInContract.SignInState, SignInContract.SignInSideEffect, SignInContract.SignInEvent>() {
    override fun createInitialState(): SignInContract.SignInState = SignInContract.SignInState()

    override suspend fun handleEvent(event: SignInContract.SignInEvent) {
        when (event) {
            is SignInContract.SignInEvent.OnSignUpTvClicked -> {
                setSideEffect { SignInContract.SignInSideEffect.NavigateToSignUp }
            }

            is SignInContract.SignInEvent.OnSignInBtnClicked -> {
                setSideEffect { SignInContract.SignInSideEffect.ShowToast(R.string.sign_in_success) }
                currentState.user?.let {setSideEffect { SignInContract.SignInSideEffect.NavigateToHome(user = it) } }
            }
        }
    }

    fun setUserInfo(userModel: UserModel) {
        setState { currentState.copy(user = userModel) }
    }

    fun signUp() {
        setEvent(SignInContract.SignInEvent.OnSignUpTvClicked)
    }

    fun signIn() {
        with(currentState) {
            user?.let { userInfo ->
                if (userInfo.id == inputId && userInfo.password == inputPassword) {
                    setEvent(SignInContract.SignInEvent.OnSignInBtnClicked)
                }
            }
        }
    }

    fun updateId(id: String) = setState { currentState.copy(inputId = id) }

    fun updatePassword(password: String) =
        setState { currentState.copy(inputPassword = password) }

}