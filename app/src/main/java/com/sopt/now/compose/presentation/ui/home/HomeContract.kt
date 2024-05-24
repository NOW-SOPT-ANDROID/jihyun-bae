package com.sopt.now.compose.presentation.ui.home

import com.sopt.now.compose.domain.model.ProfileModel
import com.sopt.now.compose.domain.model.UserModel
import com.sopt.now.compose.util.base.UiEvent
import com.sopt.now.compose.util.base.UiSideEffect
import com.sopt.now.compose.util.base.UiState

class HomeContract {
    data class HomeState(
        val showAddProfileDialog: Boolean = false,
        val showDeleteProfileDialog: Pair<Boolean, ProfileModel?> = Pair(false, null),
        val user: UserModel? = null,
        val profileList: List<ProfileModel> = emptyList(),
        val inputName: String = "",
        val inputSelfDescription: String = ""
    ) : UiState

    sealed interface HomeSideEffect : UiSideEffect {
        data object CloseDialog : HomeSideEffect
        data object DeleteProfile : HomeSideEffect
        data object GetProfileList : HomeSideEffect
        data object InsertProfile : HomeSideEffect
        data object ShowAddProfileDialog : HomeSideEffect
        data class ShowDeleteProfileDialog(val profileModel: ProfileModel) : HomeSideEffect
    }

    sealed class HomeEvent : UiEvent {
        data object OnAddProfileFabClicked : HomeEvent()
        data object OnAddProfileDialogBtnClicked : HomeEvent()
        data object OnDeleteProfileDialogLeftBtnClicked : HomeEvent()
        data object OnCloseDialogClicked : HomeEvent()
        data class OnProfileContainerLongClicked(val profileModel: ProfileModel) : HomeEvent()
    }
}