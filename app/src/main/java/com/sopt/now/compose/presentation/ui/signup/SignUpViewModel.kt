package com.sopt.now.compose.presentation.ui.signup

import androidx.lifecycle.viewModelScope
import com.sopt.now.compose.domain.usecase.PostSignUpUseCase
import com.sopt.now.compose.presentation.type.SignUpType
import com.sopt.now.compose.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: PostSignUpUseCase
) :
    BaseViewModel<SignUpContract.SignUpState, SignUpContract.SignUpSideEffect, SignUpContract.SignUpEvent>() {
    override fun createInitialState(): SignUpContract.SignUpState = SignUpContract.SignUpState()

    override suspend fun handleEvent(event: SignUpContract.SignUpEvent) {
        when (event) {
            is SignUpContract.SignUpEvent.OnSignUpBtnClicked -> {
                setSideEffect { SignUpContract.SignUpSideEffect.PopBackStack }
                setSideEffect { SignUpContract.SignUpSideEffect.NavigateToSignIn }
            }
        }
    }

    fun signUp() {
        viewModelScope.launch {
            signUpUseCase(currentState.user.copy()).onSuccess { message ->
                setSideEffect { SignUpContract.SignUpSideEffect.ShowToast(message) }
                setEvent(SignUpContract.SignUpEvent.OnSignUpBtnClicked)
            }.onFailure { throwable ->
                throwable.message?.let { setSideEffect { SignUpContract.SignUpSideEffect.ShowToast(it) } }
            }
        }
    }

    fun updateId(id: String) = setState { currentState.copy(user = user.copy(authenticationId = id)) }

    fun updatePassword(password: String) =
        setState { currentState.copy(user = user.copy(password = password)) }

    fun updateNickname(nickname: String) =
        setState { currentState.copy(user = user.copy(nickname = nickname)) }

    fun updatePhone(phone: String) = setState { currentState.copy(user = user.copy(phone = phone)) }
}