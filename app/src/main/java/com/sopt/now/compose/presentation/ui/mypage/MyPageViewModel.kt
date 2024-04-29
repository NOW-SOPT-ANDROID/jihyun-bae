package com.sopt.now.compose.presentation.ui.mypage

import com.sopt.now.compose.domain.model.UserEntity
import com.sopt.now.compose.domain.usecase.ClearDataSourceUseCase
import com.sopt.now.compose.domain.usecase.GetUserUseCase
import com.sopt.now.compose.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val clearDataSourceUseCase: ClearDataSourceUseCase,
    private val getUserUseCase: GetUserUseCase
) : BaseViewModel<MyPageContract.MyPageState, MyPageContract.MyPageSideEffect, MyPageContract.MyPageEvent>() {

    init {
        setUserInfo(userEntity = getUserUseCase())
    }

    override fun createInitialState(): MyPageContract.MyPageState = MyPageContract.MyPageState()

    override suspend fun handleEvent(event: MyPageContract.MyPageEvent) {
        when (event) {
            is MyPageContract.MyPageEvent.OnLogoutTvClicked -> {
                setSideEffect { MyPageContract.MyPageSideEffect.NavigateToSignIn }
            }
        }
    }

    private fun setUserInfo(userEntity: UserEntity) {
        setState { currentState.copy(user = userEntity) }
    }

    fun logout() {
        clearDataSourceUseCase()
        setEvent(MyPageContract.MyPageEvent.OnLogoutTvClicked)
    }
}