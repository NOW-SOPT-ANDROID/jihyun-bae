package com.sopt.now.compose.presentation.ui.home

import com.sopt.now.compose.domain.model.ProfileEntity
import com.sopt.now.compose.domain.model.UserEntity
import com.sopt.now.compose.util.base.UiEvent
import com.sopt.now.compose.util.base.UiSideEffect
import com.sopt.now.compose.util.base.UiState

class HomeContract {
    data class HomeState(
        val user: UserEntity? = null,
        val profileList: List<ProfileEntity> = emptyList()
    ) : UiState

    sealed interface HomeSideEffect : UiSideEffect

    sealed class HomeEvent : UiEvent
}