package com.sopt.now.compose.presentation.ui.list

import com.sopt.now.compose.domain.model.FakeRepoModel
import com.sopt.now.compose.util.base.UiEvent
import com.sopt.now.compose.util.base.UiSideEffect
import com.sopt.now.compose.util.base.UiState

class ListContract {
    data class ListState(
        val fakeRepoList: List<FakeRepoModel> = emptyList()
    ) : UiState

    sealed interface ListSideEffect : UiSideEffect

    sealed class ListEvent : UiEvent
}