package com.sopt.now.feature.ui.signin

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
class SignInViewModel @Inject constructor(
    private val soptRepository: SoptRepository
) : ViewModel() {
    private val _userInfo: MutableStateFlow<UserEntity?> = MutableStateFlow(null)
    val userInfo get() = _userInfo.asStateFlow()

    private val _isLogin: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLogin get() = _isLogin.asStateFlow()

    private fun setIsLogin(isLogin: Boolean) {
        viewModelScope.launch {
            soptRepository.setIsLogin(isLogin = isLogin)
        }
    }

    fun fetchUserInfo() {
        viewModelScope.launch {
            soptRepository.user.collect { userEntity ->
                _userInfo.value = userEntity
            }
        }
    }

    fun fetchAutoLogin() {
        viewModelScope.launch {
            soptRepository.isLogin.collect { isLogin ->
                _isLogin.value = isLogin
            }
        }
    }

    fun signIn(id: String, password: String): Boolean = userInfo.value?.let { userEntity ->
        (userEntity.id == id && userEntity.password == password).let { isLogin ->
            setIsLogin(isLogin)
            isLogin
        }
    } ?: false
}