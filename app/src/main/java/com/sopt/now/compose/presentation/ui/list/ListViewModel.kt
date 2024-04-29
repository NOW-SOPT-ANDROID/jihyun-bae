package com.sopt.now.compose.presentation.ui.list

import androidx.lifecycle.viewModelScope
import com.sopt.now.compose.domain.usecase.GetFakeRepoListUseCase
import com.sopt.now.compose.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getFakeRepoListUseCase: GetFakeRepoListUseCase
) : BaseViewModel<ListContract.ListState, ListContract.ListSideEffect, ListContract.ListEvent>() {
    init {
        getFakeRepoList()
    }

    override fun createInitialState(): ListContract.ListState = ListContract.ListState()

    override suspend fun handleEvent(event: ListContract.ListEvent) {
    }

    private fun getFakeRepoList() {
        viewModelScope.launch {
            getFakeRepoListUseCase().onSuccess { fakeRepoList ->
                setState { currentState.copy(fakeRepoList = fakeRepoList) }
            }
        }
    }
}