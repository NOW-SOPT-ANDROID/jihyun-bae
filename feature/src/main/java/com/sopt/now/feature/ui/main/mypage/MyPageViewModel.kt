package com.sopt.now.feature.ui.main.mypage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.now.coreui.util.view.UiState
import com.sopt.now.domain.model.SoptUserInfoModel
import com.sopt.now.domain.repository.SoptRepository
import com.sopt.now.domain.usecase.GetUserInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val soptRepository: SoptRepository,
    private val getUserInfoUseCase: GetUserInfoUseCase
) : ViewModel() {
    private val _userId: MutableStateFlow<Int?> = MutableStateFlow(null)
    val userId get() = _userId.asStateFlow()

    private val _getUserInfoState = MutableSharedFlow<UiState<SoptUserInfoModel?>>()
    val getUserInfoState get() = _getUserInfoState.asSharedFlow()

    fun fetchUserId() {
        viewModelScope.launch {
            soptRepository.userId.collect { isLogin ->
                _userId.value = isLogin
            }
        }
    }

    fun getUserInfo(memberId: Int) {
        viewModelScope.launch {
            _getUserInfoState.emit(UiState.Loading)
            getUserInfoUseCase(memberId = memberId).onSuccess { soptUserInfoEntity ->
                _getUserInfoState.emit(UiState.Success(soptUserInfoEntity))
            }.onFailure { throwable ->
                _getUserInfoState.emit(UiState.Error(throwable.message))
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            soptRepository.clear()
        }
    }
}