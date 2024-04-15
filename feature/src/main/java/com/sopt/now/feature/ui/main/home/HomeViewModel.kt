package com.sopt.now.feature.ui.main.home

import androidx.lifecycle.ViewModel
import com.sopt.now.feature.model.ProfileModel

class HomeViewModel() : ViewModel() {
    private val _mockProfileList = listOf<ProfileModel>(
        ProfileModel(
            profileImage = "https://avatars.githubusercontent.com/u/103172971?v=4",
            name = "배지현",
        ),
        ProfileModel(
            profileImage = "https://avatars.githubusercontent.com/u/91470334?v=4",
            name = "이가을"
        ),
        ProfileModel(
            profileImage = "https://avatars.githubusercontent.com/u/112953135?v=4",
            name = "이석찬"
        ),
        ProfileModel(
            profileImage = "https://avatars.githubusercontent.com/u/131870144?v=4",
            name = "김윤서"
        ),
        ProfileModel(
            profileImage = "https://avatars.githubusercontent.com/u/93872496?v=4",
            name = "곽의진",
            selfDescription = "팟짱 ㅋ"
        ),
        ProfileModel(
            profileImage = "https://avatars.githubusercontent.com/u/113014331?v=4",
            name = "우상욱"
        ),
        ProfileModel(
            profileImage = "https://avatars.githubusercontent.com/u/52882799?v=4",
            name = "박동민"
        ),
        ProfileModel(
            profileImage = "https://avatars.githubusercontent.com/u/85453429?v=4",
            name = "김언지"
        ),
        ProfileModel(
            profileImage = "https://avatars.githubusercontent.com/u/106955456?v=4",
            name = "배찬우"
        )
    )
    val mockProfileList
        get() = _mockProfileList
}