package com.sopt.now.compose.presentation.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sopt.now.compose.theme.NOWSOPTAndroidTheme

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    HomeScreen(
        state = uiState
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    state: HomeContract.HomeState = HomeContract.HomeState()
) {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        state.profileList.partition { it.id == 0 }.let { (myProfiles, friendProfiles) ->
            items(myProfiles) { myProfile ->
                ProfileContainer(profileEntity = myProfile)
            }
            friendProfiles.groupBy { friendProfile ->
                friendProfile.name.first()
            }.forEach { (firstName, profileEntities) ->
                stickyHeader {
                    HomeStickyHeader(title = firstName.toString())
                }
                items(profileEntities) { profile ->
                    ProfileContainer(profileEntity = profile)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    NOWSOPTAndroidTheme {
        HomeScreen()
    }
}