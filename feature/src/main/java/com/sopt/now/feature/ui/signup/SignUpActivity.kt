package com.sopt.now.feature.ui.signup

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.sopt.now.coreui.base.BindingActivity
import com.sopt.now.coreui.util.context.showToast
import com.sopt.now.coreui.util.view.UiState
import com.sopt.now.domain.model.SoptUserModel
import com.sopt.now.feature.databinding.ActivitySignUpBinding
import com.sopt.now.feature.ui.signin.SignInActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class SignUpActivity :
    BindingActivity<ActivitySignUpBinding>({ ActivitySignUpBinding.inflate(it) }) {
    private val signUpViewModel by viewModels<SignUpViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()
        collectSignUpState()
        setSignUpBtnClickListeners()
    }

    private fun initLayout() {
        with(binding) {
            etSignUpId.editText.inputType = InputType.TYPE_CLASS_TEXT
            etSignUpPassword.editText.inputType =
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            etSignUpNickname.editText.inputType = InputType.TYPE_CLASS_TEXT
            etSignUpPhone.editText.inputType = InputType.TYPE_CLASS_TEXT
        }
    }

    private fun collectSignUpState() {
        signUpViewModel.signUpState.flowWithLifecycle(lifecycle).onEach { uiState ->
            when (uiState) {
                is UiState.Success -> {
                    showToast(uiState.data)
                    navigateToSignIn()
                }

                is UiState.Error -> showToast(uiState.message.orEmpty())
                else -> Unit
            }
        }.launchIn(lifecycleScope)
    }

    private fun setSignUpBtnClickListeners() {
        with(binding) {
            btnSignUp.setOnClickListener {
                signUpViewModel.signUp(
                    soptUserModel = SoptUserModel(
                        authenticationId = etSignUpId.editText.text.toString(),
                        password = etSignUpPassword.editText.text.toString(),
                        nickname = etSignUpNickname.editText.text.toString(),
                        phone = etSignUpPhone.editText.text.toString()
                    )
                )
            }
        }
    }

    private fun navigateToSignIn() {
        Intent(this@SignUpActivity, SignInActivity::class.java).apply {
            startActivity(this)
            finish()
        }
    }
}