package com.sopt.now.compose.presentation.ui.signin

import androidx.lifecycle.viewModelScope
import com.sopt.now.compose.domain.usecase.GetIsLoginUseCase
import com.sopt.now.compose.domain.usecase.GetUserIdUseCase
import com.sopt.now.compose.domain.usecase.PostSignInUseCase
import com.sopt.now.compose.domain.usecase.SetIsLoginUseCase
import com.sopt.now.compose.domain.usecase.SetUserIdUseCase
import com.sopt.now.compose.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val getUserIdUseCase: GetUserIdUseCase,
    private val getIsLoginUseCase: GetIsLoginUseCase,
    private val setIsLoginUseCase: SetIsLoginUseCase,
    private val setUserIdUseCase: SetUserIdUseCase,
    private val signInUseCase: PostSignInUseCase
) : BaseViewModel<SignInContract.SignInState, SignInContract.SignInSideEffect, SignInContract.SignInEvent>() {
    init {
        if (getIsLoginUseCase()) setSideEffect { SignInContract.SignInSideEffect.NavigateToHome }
    }

    override fun createInitialState(): SignInContract.SignInState = SignInContract.SignInState()

    override suspend fun handleEvent(event: SignInContract.SignInEvent) {
        when (event) {
            is SignInContract.SignInEvent.OnSignUpTvClicked -> {
                setSideEffect { SignInContract.SignInSideEffect.NavigateToSignUp }
            }

            is SignInContract.SignInEvent.OnSignInBtnClicked -> {
                setSideEffect { SignInContract.SignInSideEffect.ShowToast(getUserIdUseCase().toString()) }
                setSideEffect { SignInContract.SignInSideEffect.PopBackStack }
                setSideEffect { SignInContract.SignInSideEffect.NavigateToHome }
            }
        }
    }

    fun signUp() {
        setEvent(SignInContract.SignInEvent.OnSignUpTvClicked)
    }

    fun signIn() {
        viewModelScope.launch {
            signInUseCase(authenticationId = currentState.inputId, password = currentState.inputPassword).onSuccess { userId ->
                setIsLoginUseCase(isLogin = true)
                userId?.let { setUserIdUseCase(userId = it) }
                setEvent(SignInContract.SignInEvent.OnSignInBtnClicked)
            }.onFailure { throwable ->
                throwable.message?.let { setSideEffect { SignInContract.SignInSideEffect.ShowToast(it) } }
            }
        }
    }

    fun updateId(id: String) = setState { currentState.copy(inputId = id) }

    fun updatePassword(password: String) =
        setState { currentState.copy(inputPassword = password) }

}