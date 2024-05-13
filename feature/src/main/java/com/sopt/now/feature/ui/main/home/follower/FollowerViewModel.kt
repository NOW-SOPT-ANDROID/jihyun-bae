package com.sopt.now.feature.ui.main.home.follower

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.now.coreui.util.view.UiState
import com.sopt.now.domain.model.ReqresUserModel
import com.sopt.now.domain.usecase.GetReqresListUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FollowerViewModel @Inject constructor(
    private val getReqresListUsersUseCase: GetReqresListUsersUseCase
) : ViewModel() {
    private val _getReqresListUsersState = MutableSharedFlow<UiState<List<ReqresUserModel>>>()
    val getReqresListUserState get() = _getReqresListUsersState.asSharedFlow()

    fun getReqresListUsers(page: Int = 1) {
        viewModelScope.launch {
            _getReqresListUsersState.emit(UiState.Loading)
            getReqresListUsersUseCase(page = page).onSuccess { reqresUserList ->
                _getReqresListUsersState.emit(UiState.Success(reqresUserList))
            }.onFailure { throwable ->
                _getReqresListUsersState.emit(UiState.Error(throwable.message))
            }
        }
    }
}