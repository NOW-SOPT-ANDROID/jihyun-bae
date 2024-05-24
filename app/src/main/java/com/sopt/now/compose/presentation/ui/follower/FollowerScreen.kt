package com.sopt.now.compose.presentation.ui.follower

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
import com.sopt.now.compose.domain.model.ReqresUserModel
import com.sopt.now.compose.theme.NOWSOPTAndroidTheme

@Composable
fun FollowerRoute(
    viewModel: FollowerViewModel = hiltViewModel()
) {
    val uistate by viewModel.uiState.collectAsState()

    viewModel.getReqresUsers()

    FollowerScreen(
        state = uistate
    )
}

@Composable
fun FollowerScreen(
    state: FollowerContract.FollowerState = FollowerContract.FollowerState()
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(state.followerList) { reqresUserEntity ->
            FollowerContainer(reqresUserModel = reqresUserEntity)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FollowerScreenPreview() {
    NOWSOPTAndroidTheme {
        FollowerScreen(
            state = FollowerContract.FollowerState(
                followerList = listOf(
                    ReqresUserModel(
                        id = 0,
                        avatar = "https://avatars.githubusercontent.com/u/103172971?v=4",
                        firstName = "ㅋㅋ",
                        lastName = "배지현",
                        email = "어쩌구저쩌구"
                    )
                )
            )
        )
    }
}