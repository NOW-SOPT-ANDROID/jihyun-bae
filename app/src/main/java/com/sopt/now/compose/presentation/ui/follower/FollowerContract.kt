package com.sopt.now.compose.presentation.ui.follower

import com.sopt.now.compose.domain.model.ReqresUserModel
import com.sopt.now.compose.util.base.UiEvent
import com.sopt.now.compose.util.base.UiSideEffect
import com.sopt.now.compose.util.base.UiState

class FollowerContract {
    data class FollowerState(
        val followerList: List<ReqresUserModel> = emptyList()
    ) : UiState

    sealed interface FollowerSideEffect : UiSideEffect

    sealed class FollowerEvent : UiEvent
}