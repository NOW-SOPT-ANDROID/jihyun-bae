package com.sopt.now.compose.presentation.ui.list

import androidx.lifecycle.viewModelScope
import com.sopt.now.compose.domain.usecase.GetFakeReposUseCase
import com.sopt.now.compose.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getFakeReposUseCase: GetFakeReposUseCase
) : BaseViewModel<ListContract.ListState, ListContract.ListSideEffect, ListContract.ListEvent>() {
    init {
        getFakeRepos()
    }

    override fun createInitialState(): ListContract.ListState = ListContract.ListState()

    override suspend fun handleEvent(event: ListContract.ListEvent) {
    }

    private fun getFakeRepos() {
        viewModelScope.launch {
            getFakeReposUseCase().onSuccess { fakeRepoList ->
                setState { currentState.copy(fakeRepoList = fakeRepoList) }
            }
        }
    }
}