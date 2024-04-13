package com.sopt.now.feature.ui.signin

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.sopt.now.coreui.base.BindingActivity
import com.sopt.now.coreui.util.context.showToast
import com.sopt.now.coreui.util.context.stringOf
import com.sopt.now.feature.databinding.ActivitySignInBinding
import com.sopt.now.feature.ui.main.MainActivity
import com.sopt.now.feature.ui.signup.SignUpActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.sopt.now.designsystem.R

@AndroidEntryPoint
class SignInActivity :
    BindingActivity<ActivitySignInBinding>({ ActivitySignInBinding.inflate(it) }) {
    private val signInViewModel by viewModels<SignInViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        signInViewModel.fetchUserInfo()
        signInViewModel.fetchAutoLogin()
        initLayout()
        setSignInBtnClickListeners()
        setSignUpTvClickListener()
        collectIsLogin()
    }

    private fun initLayout() {
        with(binding) {
            etSignInId.editText.inputType = InputType.TYPE_CLASS_TEXT
            etSignInPassword.editText.inputType =
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        }
    }

    private fun setSignInBtnClickListeners() {
        binding.btnSignIn.setOnClickListener {
            signInViewModel.signIn(
                id = binding.etSignInId.editText.text.toString(),
                password = binding.etSignInPassword.editText.text.toString()
            ).let { isSignInSuccess ->
                if (isSignInSuccess) navigateToMain()
            }
        }
    }

    private fun setSignUpTvClickListener() {
        binding.tvSignInSignUp.setOnClickListener {
            navigateToSignUp()
        }
    }

    private fun collectIsLogin() {
        signInViewModel.isLogin.flowWithLifecycle(lifecycle).onEach { isLogin ->
            if (isLogin) {
                showToast(stringOf(R.string.sign_in_success))
                navigateToMain()
            }
        }.launchIn(lifecycleScope)
    }

    private fun navigateToSignUp() {
        startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
    }

    private fun navigateToMain() {
        Intent(this@SignInActivity, MainActivity::class.java).apply {
            startActivity(this)
            finish()
        }
    }
}