package com.sopt.now.compose.presentation.ui.signin

import com.sopt.now.compose.R
import com.sopt.now.compose.domain.model.UserEntity
import com.sopt.now.compose.domain.usecase.GetIsLoginUseCase
import com.sopt.now.compose.domain.usecase.GetUserUseCase
import com.sopt.now.compose.domain.usecase.SetIsLoginUseCase
import com.sopt.now.compose.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val getIsLoginUseCase: GetIsLoginUseCase,
    private val setIsLoginUseCase: SetIsLoginUseCase
) : BaseViewModel<SignInContract.SignInState, SignInContract.SignInSideEffect, SignInContract.SignInEvent>() {
    init {
        if (getIsLoginUseCase()) setSideEffect { SignInContract.SignInSideEffect.NavigateToHome }
        setUserInfo(userEntity = getUserUseCase())
    }

    override fun createInitialState(): SignInContract.SignInState = SignInContract.SignInState()

    override suspend fun handleEvent(event: SignInContract.SignInEvent) {
        when (event) {
            is SignInContract.SignInEvent.OnSignUpTvClicked -> {
                setSideEffect { SignInContract.SignInSideEffect.NavigateToSignUp }
            }

            is SignInContract.SignInEvent.OnSignInBtnClicked -> {
                setSideEffect { SignInContract.SignInSideEffect.ShowToast(R.string.sign_in_success) }
                setSideEffect { SignInContract.SignInSideEffect.PopBackStack }
                setSideEffect { SignInContract.SignInSideEffect.NavigateToHome }
            }
        }
    }

    private fun setUserInfo(userEntity: UserEntity) {
        setState { currentState.copy(user = userEntity) }
    }

    fun signUp() {
        setEvent(SignInContract.SignInEvent.OnSignUpTvClicked)
    }

    fun signIn() {
        with(currentState) {
            user?.let { userInfo ->
                if (userInfo.id == inputId && userInfo.password == inputPassword) {
                    setIsLoginUseCase(isLogin = true)
                    setEvent(SignInContract.SignInEvent.OnSignInBtnClicked)
                }
            }
        }
    }

    fun updateId(id: String) = setState { currentState.copy(inputId = id) }

    fun updatePassword(password: String) =
        setState { currentState.copy(inputPassword = password) }

}