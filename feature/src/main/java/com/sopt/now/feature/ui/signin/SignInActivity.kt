package com.sopt.now.feature.ui.signin

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.sopt.now.coreui.base.BindingActivity
import com.sopt.now.coreui.util.context.showToast
import com.sopt.now.coreui.util.context.stringOf
import com.sopt.now.coreui.util.intent.getCompatibleParcelableExtra
import com.sopt.now.feature.databinding.ActivitySignInBinding
import com.sopt.now.feature.model.UserModel
import com.sopt.now.feature.ui.main.MainActivity
import com.sopt.now.feature.ui.signup.SignUpActivity
import com.sopt.now.feature.ui.signup.SignUpActivity.Companion.USER_INFO

class SignInActivity :
    BindingActivity<ActivitySignInBinding>({ ActivitySignInBinding.inflate(it) }) {
    private val signInViewModel by viewModels<SignInViewModel>()
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()
        addListeners()
        setResultLauncher()
    }

    private fun initLayout() {
        binding.etSignInPassword.editText.inputType =
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
    }

    private fun addListeners() {
        binding.btnSignIn.setOnClickListener {
            signInViewModel.signIn(
                inputId = binding.etSignInId.editText.text.toString(),
                inputPassword = binding.etSignInPassword.editText.text.toString()
            ).let { isSignInSuccess ->
                if (isSignInSuccess) {
                    navigateToMain()
                    showToast(stringOf(org.sopt.now.designsystem.R.string.sign_in_success))
                }
            }
        }

        binding.tvSignInSignUp.setOnClickListener {
            navigateToSignUp()
        }
    }

    private fun setResultLauncher() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
                if (activityResult.resultCode == RESULT_OK) {
                    binding.etSignInId.editText.text.clear()
                    binding.etSignInPassword.editText.text.clear()
                    activityResult.data?.getCompatibleParcelableExtra<UserModel>(USER_INFO)
                        ?.let { userModel ->
                            signInViewModel.setUser(userModel)
                        }
                }
            }
    }

    private fun navigateToSignUp() {
        Intent(this@SignInActivity, SignUpActivity::class.java).apply {
            resultLauncher.launch(this)
        }
    }

    private fun navigateToMain() {
        Intent(this@SignInActivity, MainActivity::class.java).apply {
            putExtra(USER_INFO, signInViewModel.user)
            startActivity(this)
            finish()
        }
    }
}