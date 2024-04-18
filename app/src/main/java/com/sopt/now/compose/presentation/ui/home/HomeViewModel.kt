package com.sopt.now.compose.presentation.ui.home

import com.sopt.now.compose.domain.model.ProfileEntity
import com.sopt.now.compose.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() :
    BaseViewModel<HomeContract.HomeState, HomeContract.HomeSideEffect, HomeContract.HomeEvent>() {
    private val _mockProfileList: List<ProfileEntity> = listOf<ProfileEntity>(
        ProfileEntity(
            id = 0,
            profileImage = "https://avatars.githubusercontent.com/u/103172971?v=4",
            name = "배지현"
        ),
        ProfileEntity(
            id = 1,
            profileImage = "https://avatars.githubusercontent.com/u/91470334?v=4",
            name = "이가을"
        ),
        ProfileEntity(
            id = 2,
            profileImage = "https://avatars.githubusercontent.com/u/112953135?v=4",
            name = "이석찬"
        ),
        ProfileEntity(
            id = 3,
            profileImage = "https://avatars.githubusercontent.com/u/131870144?v=4",
            name = "김윤서"
        ),
        ProfileEntity(
            id = 4,
            profileImage = "https://avatars.githubusercontent.com/u/93872496?v=4",
            name = "곽의진",
            selfDescription = "팟짱 ㅋ"
        ),
        ProfileEntity(
            id = 5,
            profileImage = "https://avatars.githubusercontent.com/u/113014331?v=4",
            name = "우상욱"
        ),
        ProfileEntity(
            id = 6,
            profileImage = "https://avatars.githubusercontent.com/u/52882799?v=4",
            name = "박동민"
        ),
        ProfileEntity(
            id = 7,
            profileImage = "https://avatars.githubusercontent.com/u/85453429?v=4",
            name = "김언지"
        ),
        ProfileEntity(
            id = 8,
            profileImage = "https://avatars.githubusercontent.com/u/106955456?v=4",
            name = "배찬우"
        ),
        ProfileEntity(
            id = 9,
            profileImage = "https://avatars.githubusercontent.com/u/127238018?v=4",
            name = "최준서"
        ),
        ProfileEntity(
            id = 10,
            profileImage = "https://avatars.githubusercontent.com/u/128459613?v=4",
            name = "이유빈"
        )
    )

    init {
        getProfileList()
    }

    override fun createInitialState(): HomeContract.HomeState = HomeContract.HomeState()

    override suspend fun handleEvent(event: HomeContract.HomeEvent) {}

    private fun getProfileList() {
        setState { currentState.copy(profileList = _mockProfileList) }
    }
}