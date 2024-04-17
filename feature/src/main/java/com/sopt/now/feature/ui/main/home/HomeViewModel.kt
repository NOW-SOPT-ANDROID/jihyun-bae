package com.sopt.now.feature.ui.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.now.coreui.util.view.UiState
import com.sopt.now.domain.model.ProfileEntity
import com.sopt.now.domain.usecase.DeleteProfileUseCase
import com.sopt.now.domain.usecase.GetProfileListUseCase
import com.sopt.now.domain.usecase.InsertProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val deleteProfileUseCase: DeleteProfileUseCase,
    private val getProfileListUseCase: GetProfileListUseCase,
    private val insertProfileUseCase: InsertProfileUseCase
) : ViewModel() {
    private val _profileListState = MutableStateFlow<UiState<List<ProfileEntity>>>(UiState.Empty)
    val profileListState get() = _profileListState.asStateFlow()

    fun deleteProfile(profile: ProfileEntity) {
        viewModelScope.launch {
            deleteProfileUseCase(profile = profile)
            getProfileList()
        }
    }

    fun getProfileList() {
        viewModelScope.launch {
            _profileListState.value = UiState.Loading
            getProfileListUseCase().onSuccess { profileList ->
                _profileListState.value = UiState.Success(profileList)
            }.onFailure { throwable ->
                _profileListState.value = UiState.Error(throwable.message)
            }
        }
    }

    fun insertProfile(profile: ProfileEntity) {
        viewModelScope.launch {
            insertProfileUseCase(profile = profile)
            getProfileList()
        }
    }
}