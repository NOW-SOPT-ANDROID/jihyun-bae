package com.sopt.now.compose.presentation.ui.home

import com.sopt.now.compose.domain.model.UserEntity
import com.sopt.now.compose.domain.usecase.GetUserUseCase
import com.sopt.now.compose.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : BaseViewModel<HomeContract.HomeState, HomeContract.HomeSideEffect, HomeContract.HomeEvent>() {

    init {
        setUserInfo(userEntity = getUserUseCase())
    }

    override fun createInitialState(): HomeContract.HomeState = HomeContract.HomeState()

    override suspend fun handleEvent(event: HomeContract.HomeEvent) {

    }

    fun setUserInfo(userEntity: UserEntity) {
        setState { currentState.copy(user = userEntity) }
    }
}