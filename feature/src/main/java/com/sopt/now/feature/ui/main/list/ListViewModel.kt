package com.sopt.now.feature.ui.main.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.now.coreui.util.view.UiState
import com.sopt.now.domain.model.FakeRepoModel
import com.sopt.now.domain.usecase.GetFakeReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getFakeReposUseCase: GetFakeReposUseCase
) : ViewModel() {
    private val _fakeRepoListState =
        MutableStateFlow<UiState<List<FakeRepoModel>>>(UiState.Empty)
    val fakeRepoListState get() = _fakeRepoListState.asStateFlow()

    fun getFakeRepoList() {
        viewModelScope.launch {
            _fakeRepoListState.value = UiState.Loading
            getFakeReposUseCase().onSuccess { fakeRepoList ->
                _fakeRepoListState.value = UiState.Success(fakeRepoList)
            }.onFailure { throwable ->
                _fakeRepoListState.value = UiState.Error(throwable.message)
            }
        }
    }
}