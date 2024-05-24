package com.sopt.now.feature.ui.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.now.coreui.util.view.UiState
import com.sopt.now.domain.repository.SoptRepository
import com.sopt.now.domain.usecase.PostSignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val soptRepository: SoptRepository,
    private val postSignInUseCase: PostSignInUseCase
) : ViewModel() {
    private val _userId: MutableStateFlow<Int?> = MutableStateFlow(null)
    val userId get() = _userId.asStateFlow()

    private val _signInState = MutableSharedFlow<UiState<Int?>>()
    val signInState get() = _signInState.asSharedFlow()

    fun setUserId(userId: Int) {
        viewModelScope.launch {
            soptRepository.setUserId(userId = userId)
        }
    }

    fun fetchUserId() {
        viewModelScope.launch {
            soptRepository.userId.collect { isLogin ->
                _userId.value = isLogin
            }
        }
    }

    fun signIn(authenticationId: String, password: String) {
        viewModelScope.launch {
            _signInState.emit(UiState.Loading)
            postSignInUseCase(
                authenticationId = authenticationId,
                password = password
            ).onSuccess { memberId ->
                _signInState.emit(UiState.Success(memberId))
            }.onFailure { throwable ->
                _signInState.emit(UiState.Error(throwable.message))
            }
        }
    }
}