package com.sopt.now.compose.presentation.ui.home

import com.sopt.now.compose.domain.model.UserEntity
import com.sopt.now.compose.util.base.UiEvent
import com.sopt.now.compose.util.base.UiSideEffect
import com.sopt.now.compose.util.base.UiState

class HomeContract {
    data class HomeState(
        val user: UserEntity? = null
    ) : UiState

    sealed interface HomeSideEffect : UiSideEffect {
        data object NavigateToSignIn : HomeSideEffect
    }

    sealed class HomeEvent : UiEvent {
        data object OnLogoutTvClicked : HomeEvent()
    }
}