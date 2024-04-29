package com.sopt.now.compose.presentation.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sopt.now.compose.domain.model.FakeRepoEntity
import com.sopt.now.compose.theme.NOWSOPTAndroidTheme

@Composable
fun ListRoute(
    viewModel: ListViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    ListScreen(
        state = uiState
    )
}

@Composable
fun ListScreen(
    state: ListContract.ListState = ListContract.ListState()
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(state.fakeRepoList) { fakeRepoEntity ->
            FakeRepoContainer(fakeRepoEntity = fakeRepoEntity)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    NOWSOPTAndroidTheme {
        ListScreen(
            state = ListContract.ListState(
                fakeRepoList = listOf(
                    FakeRepoEntity(
                        id = 0,
                        name = "repo",
                        description = null
                    )
                )
            )
        )
    }
}