package com.sopt.now.compose.presentation.ui.signup

import com.sopt.now.compose.domain.model.UserEntity
import com.sopt.now.compose.domain.usecase.SetUserIdUseCase
import com.sopt.now.compose.presentation.type.SignUpType
import com.sopt.now.compose.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val setUserUseCase: SetUserIdUseCase
) :
    BaseViewModel<SignUpContract.SignUpState, SignUpContract.SignUpSideEffect, SignUpContract.SignUpEvent>() {
    override fun createInitialState(): SignUpContract.SignUpState = SignUpContract.SignUpState()

    override suspend fun handleEvent(event: SignUpContract.SignUpEvent) {
        when (event) {
            is SignUpContract.SignUpEvent.OnSignUpBtnClicked -> {
                setSideEffect { SignUpContract.SignUpSideEffect.ShowToast(SignUpType.SUCCESS) }
                setSideEffect { SignUpContract.SignUpSideEffect.PopBackStack }
                setSideEffect { SignUpContract.SignUpSideEffect.NavigateToSignIn(userEntity = currentState.user) }
            }
        }
    }

    fun signUp() {
        with(currentState.user) {
            when {
                id.length !in MIN_ID_LENGTH..MAX_ID_LENGTH -> setSideEffect {
                    SignUpContract.SignUpSideEffect.ShowToast(
                        SignUpType.ID_ERROR
                    )
                }

                password.length !in MIN_PASSWORD_LENGTH..MAX_PASSWORD_LENGTH -> setSideEffect {
                    SignUpContract.SignUpSideEffect.ShowToast(
                        SignUpType.PASSWORD_ERROR
                    )
                }

                nickname.isBlank() -> setSideEffect {
                    SignUpContract.SignUpSideEffect.ShowToast(
                        SignUpType.NICKNAME_ERROR
                    )
                }

                !mbti.matches(MBTI_REGEX) -> setSideEffect {
                    SignUpContract.SignUpSideEffect.ShowToast(
                        SignUpType.MBTI_ERROR
                    )
                }

                else -> {
                    setEvent(SignUpContract.SignUpEvent.OnSignUpBtnClicked)
                }
            }
        }
    }

    fun setUser(user: UserEntity) {
        setUserUseCase(user = user)
    }

    fun updateId(id: String) = setState { currentState.copy(user = user.copy(id = id)) }

    fun updatePassword(password: String) =
        setState { currentState.copy(user = user.copy(password = password)) }

    fun updateNickname(nickname: String) =
        setState { currentState.copy(user = user.copy(nickname = nickname)) }

    fun updateMbti(mbti: String) = setState { currentState.copy(user = user.copy(mbti = mbti)) }

    companion object {
        private const val MIN_ID_LENGTH = 6
        private const val MAX_ID_LENGTH = 10
        private const val MIN_PASSWORD_LENGTH = 8
        private const val MAX_PASSWORD_LENGTH = 12
        private const val MBTI_PATTERN = "^[EI][NS][FT][JP]\$"
        private val MBTI_REGEX = Regex(MBTI_PATTERN)
    }
}