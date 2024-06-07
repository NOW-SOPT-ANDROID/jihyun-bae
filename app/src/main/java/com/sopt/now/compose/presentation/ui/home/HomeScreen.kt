package com.sopt.now.compose.presentation.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.flowWithLifecycle
import com.sopt.now.compose.domain.model.ProfileModel
import com.sopt.now.compose.presentation.type.DialogType
import com.sopt.now.compose.theme.NOWSOPTAndroidTheme
import com.sopt.now.compose.util.component.SoptAlertDialog

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { homeSideEffect ->
                when (homeSideEffect) {
                    is HomeContract.HomeSideEffect.CloseDialog -> viewModel.updateCloseDialog()

                    is HomeContract.HomeSideEffect.DeleteProfile -> {
                        viewModel.deleteProfile()
                    }

                    is HomeContract.HomeSideEffect.InsertProfile -> {
                        viewModel.insertProfile()
                    }

                    is HomeContract.HomeSideEffect.GetProfileList -> viewModel.getProfileList()

                    is HomeContract.HomeSideEffect.ShowAddProfileDialog -> viewModel.updateAddProfileDialog()

                    is HomeContract.HomeSideEffect.ShowDeleteProfileDialog -> viewModel.updateShowDeleteProfileDialog(
                        homeSideEffect.profileModel
                    )
                }
            }

    }

    HomeScreen(
        state = uiState,
        onDeleteFriendDialogLeftBtnClick = viewModel::setDeleteProfileDialogLeftBtnClickedEvent,
        onDeleteFriendDialogRightBtnClick = viewModel::setClosedDialogClickedEvent,
        onAddFriendDialogBtnClick = viewModel::setAddProfileDialogLeftBtnClickedEvent,
        onProfileLongClick = viewModel::setProfileContainerLongClickedEvent,
        onValueChangeName = viewModel::updateName,
        onValueChangeSelfDescription = viewModel::updateSelfDescription,
        onFabClick = viewModel::setAddProfileFabClickedEvent
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    state: HomeContract.HomeState = HomeContract.HomeState(),
    onDeleteFriendDialogLeftBtnClick: () -> Unit = {},
    onDeleteFriendDialogRightBtnClick: () -> Unit = {},
    onAddFriendDialogBtnClick: () -> Unit = {},
    onProfileLongClick: (ProfileModel) -> Unit = {},
    onValueChangeName: (String) -> Unit = {},
    onValueChangeSelfDescription: (String) -> Unit = {},
    onFabClick: () -> Unit = {}
) {
    Box {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            state.profileList.partition { profileModel ->
                profileModel.id == 1
            }.let { (myProfiles, friendProfiles) ->
                items(myProfiles) { myProfile ->
                    ProfileContainer(profileModel = myProfile)
                }
                friendProfiles.groupBy { friendProfile ->
                    friendProfile.name.first()
                }.toSortedMap().forEach { (firstName, profileEntities) ->
                    stickyHeader {
                        HomeStickyHeader(title = firstName.toString())
                    }
                    items(profileEntities) { profile ->
                        ProfileContainer(
                            profileModel = profile,
                            onLongClick = onProfileLongClick
                        )
                    }
                }
            }
        }
        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 24.dp, end = 24.dp),
            onClick = { onFabClick() },
            content = { Icon(imageVector = Icons.Filled.Add, contentDescription = null) }
        )

        if (state.showAddProfileDialog) {
            Column(
                modifier = Modifier.align(Alignment.Center)
            ) {
                AddProfileAlertDialog(
                    state = state,
                    clickBtn = onAddFriendDialogBtnClick,
                    onValueChangeName = onValueChangeName,
                    onValueChangeSelfDescription = onValueChangeSelfDescription
                )
            }
        }

        if (state.showDeleteProfileDialog.first) {
            Column(
                modifier = Modifier.align(Alignment.Center)
            ) {
                SoptAlertDialog(
                    dialogType = DialogType.DELETE_PROFILE,
                    clickLeftBtn = onDeleteFriendDialogLeftBtnClick,
                    clickRightBtn = onDeleteFriendDialogRightBtnClick
                )
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