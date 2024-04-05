package com.sopt.now.feature.ui.signin

import androidx.lifecycle.ViewModel
import com.sopt.now.feature.model.UserModel

class SignInViewModel : ViewModel() {
    private lateinit var _user: UserModel
    val user get() = _user

    fun setUser(user: UserModel) {
        _user = user
    }

    fun signIn(inputId: String, inputPassword: String): Boolean =
        ::_user.isInitialized && _user.id == inputId && _user.password == inputPassword
}