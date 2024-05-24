package com.sopt.now.compose.presentation.ui.mypage

import com.sopt.now.compose.domain.model.SoptUserInfoModel
import com.sopt.now.compose.util.base.UiEvent
import com.sopt.now.compose.util.base.UiSideEffect
import com.sopt.now.compose.util.base.UiState

class MyPageContract {
    data class MyPageState(
        val user: SoptUserInfoModel? = null
    ) : UiState

    sealed interface MyPageSideEffect : UiSideEffect {
        data object NavigateToSignIn : MyPageSideEffect
    }

    sealed class MyPageEvent : UiEvent {
        data object OnLogoutTvClicked : MyPageEvent()
    }
}