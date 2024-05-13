package com.sopt.now.feature.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.now.coreui.util.view.UiState
import com.sopt.now.domain.model.SoptUserModel
import com.sopt.now.domain.usecase.PostSignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val postSignUpUseCase: PostSignUpUseCase
) : ViewModel() {
    private val _signUpState = MutableSharedFlow<UiState<String>>()
    val signUpState get() = _signUpState.asSharedFlow()

    fun signUp(soptUserModel: SoptUserModel) {
        viewModelScope.launch {
            _signUpState.emit(UiState.Loading)
            postSignUpUseCase(soptUserEntity = soptUserModel).onSuccess { message ->
                _signUpState.emit(UiState.Success(message))
            }.onFailure { throwable ->
                _signUpState.emit(UiState.Error(throwable.message))
            }
        }
    }
}