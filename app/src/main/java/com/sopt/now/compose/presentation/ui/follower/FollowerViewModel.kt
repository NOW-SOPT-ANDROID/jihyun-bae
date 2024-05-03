package com.sopt.now.compose.presentation.ui.follower

import androidx.lifecycle.viewModelScope
import com.sopt.now.compose.domain.usecase.GetReqresListUsersUseCase
import com.sopt.now.compose.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FollowerViewModel @Inject constructor(
    private val getReqresListUsersUseCase: GetReqresListUsersUseCase
) : BaseViewModel<FollowerContract.FollowerState, FollowerContract.FollowerSideEffect, FollowerContract.FollowerEvent>() {
    override fun createInitialState(): FollowerContract.FollowerState =
        FollowerContract.FollowerState()

    override suspend fun handleEvent(event: FollowerContract.FollowerEvent) {
    }

    fun getReqresListUsers() {
        viewModelScope.launch {
            getReqresListUsersUseCase(page = 1).onSuccess { followerList ->
                setState { currentState.copy(followerList = followerList) }
            }
        }
    }
}