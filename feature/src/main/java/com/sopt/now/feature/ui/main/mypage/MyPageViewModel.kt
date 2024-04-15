package com.sopt.now.feature.ui.main.mypage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.now.domain.model.UserEntity
import com.sopt.now.domain.repository.SoptRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val soptRepository: SoptRepository
) : ViewModel() {
    private val _userInfo: MutableStateFlow<UserEntity?> = MutableStateFlow(null)
    val userInfo get() = _userInfo.asStateFlow()

    fun fetchUserInfo() {
        viewModelScope.launch {
            soptRepository.user.collect { userEntity ->
                _userInfo.value = userEntity
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            soptRepository.setIsLogin(isLogin = false)
        }
    }
}