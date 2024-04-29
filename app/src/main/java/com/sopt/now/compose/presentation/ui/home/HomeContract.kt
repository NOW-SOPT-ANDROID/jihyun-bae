package com.sopt.now.compose.presentation.ui.home

import com.sopt.now.compose.domain.model.ProfileEntity
import com.sopt.now.compose.domain.model.UserEntity
import com.sopt.now.compose.util.base.UiEvent
import com.sopt.now.compose.util.base.UiSideEffect
import com.sopt.now.compose.util.base.UiState

class HomeContract {
    data class HomeState(
        val showAddProfileDialog: Boolean = false,
        val showDeleteProfileDialog: Pair<Boolean, ProfileEntity?> = Pair(false, null),
        val user: UserEntity? = null,
        val profileList: List<ProfileEntity> = emptyList(),
        val inputName: String = "",
        val inputSelfDescription: String = ""
    ) : UiState

    sealed interface HomeSideEffect : UiSideEffect {
        data object CloseDialog : HomeSideEffect
        data object DeleteProfile : HomeSideEffect
        data object GetProfileList : HomeSideEffect
        data object InsertProfile : HomeSideEffect
        data object ShowAddProfileDialog : HomeSideEffect
        data class ShowDeleteProfileDialog(val profileEntity: ProfileEntity) : HomeSideEffect
    }

    sealed class HomeEvent : UiEvent {
        data object OnAddProfileFabClicked : HomeEvent()
        data object OnAddProfileDialogBtnClicked : HomeEvent()
        data object OnDeleteProfileDialogLeftBtnClicked : HomeEvent()
        data object OnCloseDialogClicked : HomeEvent()
        data class OnProfileContainerLongClicked(val profileEntity: ProfileEntity) : HomeEvent()
    }
}