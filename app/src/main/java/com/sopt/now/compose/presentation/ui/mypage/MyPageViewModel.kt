package com.sopt.now.compose.presentation.ui.mypage

import androidx.lifecycle.viewModelScope
import com.sopt.now.compose.domain.model.UserEntity
import com.sopt.now.compose.domain.usecase.ClearDataSourceUseCase
import com.sopt.now.compose.domain.usecase.GetUserIdUseCase
import com.sopt.now.compose.domain.usecase.GetUserInfoUseCase
import com.sopt.now.compose.presentation.ui.signin.SignInContract
import com.sopt.now.compose.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val clearDataSourceUseCase: ClearDataSourceUseCase,
    private val getUserIdUseCase: GetUserIdUseCase,
    private val getUserInfoUseCase: GetUserInfoUseCase
) : BaseViewModel<MyPageContract.MyPageState, MyPageContract.MyPageSideEffect, MyPageContract.MyPageEvent>() {
    override fun createInitialState(): MyPageContract.MyPageState = MyPageContract.MyPageState()

    override suspend fun handleEvent(event: MyPageContract.MyPageEvent) {
        when (event) {
            is MyPageContract.MyPageEvent.OnLogoutTvClicked -> {
                setSideEffect { MyPageContract.MyPageSideEffect.NavigateToSignIn }
            }
        }
    }

    fun getUserInfo() {
        viewModelScope.launch {
            getUserInfoUseCase(memberId = getUserIdUseCase()).onSuccess { soptUserInfoEntity ->
                setState { currentState.copy(user = soptUserInfoEntity) }
            }
        }
    }

    fun logout() {
        clearDataSourceUseCase()
        setEvent(MyPageContract.MyPageEvent.OnLogoutTvClicked)
    }
}