package com.sopt.now.compose.presentation.ui.home

import com.sopt.now.compose.presentation.model.UserModel
import com.sopt.now.compose.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel<HomeContract.HomeState, HomeContract.HomeSideEffect, HomeContract.HomeEvent>(){
    override fun createInitialState(): HomeContract.HomeState = HomeContract.HomeState()

    override suspend fun handleEvent(event: HomeContract.HomeEvent) {

    }

    fun setUserInfo(userModel: UserModel) {
        setState { currentState.copy(user = userModel) }
    }
}