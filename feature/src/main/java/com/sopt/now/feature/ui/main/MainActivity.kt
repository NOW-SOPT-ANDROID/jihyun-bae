package com.sopt.now.feature.ui.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.sopt.now.coreui.base.BindingActivity
import com.sopt.now.coreui.util.intent.getCompatibleParcelableExtra
import com.sopt.now.feature.R
import com.sopt.now.feature.databinding.ActivityMainBinding
import com.sopt.now.feature.model.UserModel
import com.sopt.now.feature.ui.signup.SignUpActivity
import com.sopt.now.feature.ui.signup.SignUpActivity.Companion.USER_INFO

class MainActivity : BindingActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()
    }

    private fun initLayout() {
        intent.getCompatibleParcelableExtra<UserModel>(USER_INFO)?.let { userModel ->
            with(binding) {
                tvMyPageMbti.text = userModel.mbti
                tvMyPageNickname.text = userModel.nickname
                tvMyPageId.text = getString(org.sopt.now.designsystem.R.string.my_page_id, userModel.id)
            }
        }
    }
}