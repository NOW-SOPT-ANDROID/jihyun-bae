package com.sopt.now.feature.ui.signup

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import androidx.activity.viewModels
import com.sopt.now.coreui.base.BindingActivity
import com.sopt.now.coreui.util.context.showToast
import com.sopt.now.coreui.util.context.stringOf
import com.sopt.now.coreui.util.view.showSnackbar
import com.sopt.now.feature.databinding.ActivitySignUpBinding
import com.sopt.now.feature.model.UserModel
import com.sopt.now.feature.type.SignUpType
import com.sopt.now.feature.ui.signin.SignInActivity

class SignUpActivity :
    BindingActivity<ActivitySignUpBinding>({ ActivitySignUpBinding.inflate(it) }) {
    private val signUpViewModel by viewModels<SignUpViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()
        setSignUpBtnClickListeners()
    }

    private fun initLayout() {
        binding.etSignUpPassword.editText.inputType =
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
    }

    private fun setSignUpBtnClickListeners() {
        with(binding) {
            btnSignUp.setOnClickListener {
                UserModel(
                    id = etSignUpId.editText.text.toString(),
                    password = etSignUpPassword.editText.text.toString(),
                    nickname = etSignUpNickname.editText.text.toString(),
                    mbti = etSignUpMbti.editText.text.toString()
                ).apply {
                    signUpViewModel.signUp(
                        user = this
                    ).let { signUpType ->
                        when (signUpType) {
                            SignUpType.SUCCESS -> {
                                showToast(stringOf(signUpType.descriptionRes))
                                navigateSignIn(this)
                            }

                            else -> {
                                binding.root.showSnackbar(stringOf(signUpType.descriptionRes))
                            }
                        }
                    }
                }
            }
        }
    }

    private fun navigateSignIn(userInfo: UserModel) {
        Intent(this@SignUpActivity, SignInActivity::class.java).apply {
            putExtra(USER_INFO, userInfo)
            setResult(RESULT_OK, this)
            finish()
        }
    }

    companion object {
        const val USER_INFO = "USER_INFO"
    }
}