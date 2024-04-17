package com.sopt.now.compose.presentation.ui.home

import com.sopt.now.compose.presentation.model.UserModel
import com.sopt.now.compose.util.base.UiEvent
import com.sopt.now.compose.util.base.UiSideEffect
import com.sopt.now.compose.util.base.UiState

class HomeContract {
    data class HomeState(
        val user: UserModel? = null
    ) : UiState

    sealed interface HomeSideEffect: UiSideEffect

    sealed class HomeEvent: UiEvent
}