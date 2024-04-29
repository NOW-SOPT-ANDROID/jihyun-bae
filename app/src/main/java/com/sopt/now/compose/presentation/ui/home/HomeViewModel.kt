package com.sopt.now.compose.presentation.ui.home

import androidx.lifecycle.viewModelScope
import com.sopt.now.compose.domain.model.ProfileEntity
import com.sopt.now.compose.domain.usecase.DeleteProfileUseCase
import com.sopt.now.compose.domain.usecase.GetProfileListUseCase
import com.sopt.now.compose.domain.usecase.InsertProfileUseCase
import com.sopt.now.compose.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val deleteProfileUseCase: DeleteProfileUseCase,
    private val getProfileListUseCase: GetProfileListUseCase,
    private val insertProfileUseCase: InsertProfileUseCase
) :
    BaseViewModel<HomeContract.HomeState, HomeContract.HomeSideEffect, HomeContract.HomeEvent>() {

    init {
        getProfileList()
    }

    override fun createInitialState(): HomeContract.HomeState = HomeContract.HomeState()

    override suspend fun handleEvent(event: HomeContract.HomeEvent) {
        when (event) {
            is HomeContract.HomeEvent.OnAddProfileFabClicked -> {
                setSideEffect { HomeContract.HomeSideEffect.ShowAddProfileDialog }
            }

            is HomeContract.HomeEvent.OnAddProfileDialogBtnClicked -> {
                setSideEffect { HomeContract.HomeSideEffect.InsertProfile }
            }

            is HomeContract.HomeEvent.OnProfileContainerLongClicked -> {
                setSideEffect { HomeContract.HomeSideEffect.ShowDeleteProfileDialog(profileEntity = event.profileEntity) }
            }

            is HomeContract.HomeEvent.OnDeleteProfileDialogLeftBtnClicked -> {
                setSideEffect { HomeContract.HomeSideEffect.DeleteProfile }
            }

            is HomeContract.HomeEvent.OnCloseDialogClicked -> {
                setSideEffect { HomeContract.HomeSideEffect.CloseDialog }
            }
        }
    }

    fun deleteProfile() {
        viewModelScope.launch {
            currentState.showDeleteProfileDialog.second?.let { deleteProfileUseCase(profile = it) }
            setSideEffect { HomeContract.HomeSideEffect.CloseDialog }
            setSideEffect { HomeContract.HomeSideEffect.GetProfileList }
        }
    }

    fun getProfileList() {
        viewModelScope.launch {
            getProfileListUseCase().onSuccess { profileList ->
                setState { currentState.copy(profileList = profileList) }
            }
        }
    }

    fun insertProfile() {
        viewModelScope.launch {
            insertProfileUseCase(
                profile = ProfileEntity(
                    name = currentState.inputName,
                    selfDescription = currentState.inputSelfDescription.ifEmpty { null }
                )
            )
            setSideEffect { HomeContract.HomeSideEffect.CloseDialog }
            setSideEffect { HomeContract.HomeSideEffect.GetProfileList }
        }
    }

    fun setAddProfileFabClickedEvent() {
        setEvent(HomeContract.HomeEvent.OnAddProfileFabClicked)
    }

    fun setAddProfileDialogLeftBtnClickedEvent() {
        setEvent(HomeContract.HomeEvent.OnAddProfileDialogBtnClicked)
    }

    fun setProfileContainerLongClickedEvent(profile: ProfileEntity) {
        setEvent(HomeContract.HomeEvent.OnProfileContainerLongClicked(profileEntity = profile))
    }

    fun setDeleteProfileDialogLeftBtnClickedEvent() {
        setEvent(HomeContract.HomeEvent.OnDeleteProfileDialogLeftBtnClicked)
    }

    fun setClosedDialogClickedEvent() {
        setEvent(HomeContract.HomeEvent.OnCloseDialogClicked)
    }

    fun updateAddProfileDialog() {
        setState { currentState.copy(showAddProfileDialog = true) }
    }

    fun updateCloseDialog() {
        setState {
            currentState.copy(
                showAddProfileDialog = false,
                showDeleteProfileDialog = showDeleteProfileDialog.copy(first = false),
                inputName = "",
                inputSelfDescription = ""
            )
        }
    }

    fun updateShowDeleteProfileDialog(profile: ProfileEntity) {
        setState {
            currentState.copy(
                showDeleteProfileDialog = showDeleteProfileDialog.copy(
                    first = true,
                    second = profile
                )
            )
        }
    }

    fun updateName(name: String) = setState { currentState.copy(inputName = name) }

    fun updateSelfDescription(selfDescription: String) =
        setState { currentState.copy(inputSelfDescription = selfDescription) }
}