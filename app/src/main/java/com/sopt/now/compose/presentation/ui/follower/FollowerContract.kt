package com.sopt.now.compose.presentation.ui.follower

import com.sopt.now.compose.domain.model.ReqresUserEntity
import com.sopt.now.compose.util.base.UiEvent
import com.sopt.now.compose.util.base.UiSideEffect
import com.sopt.now.compose.util.base.UiState

class FollowerContract {
    data class FollowerState(
        val followerList: List<ReqresUserEntity> = emptyList()
    ) : UiState

    sealed interface FollowerSideEffect : UiSideEffect

    sealed class FollowerEvent : UiEvent
}