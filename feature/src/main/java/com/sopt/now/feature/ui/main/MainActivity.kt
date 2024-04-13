package com.sopt.now.feature.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.sopt.now.coreui.base.BindingActivity
import com.sopt.now.feature.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel.fetchUserInfo()
        collectUserInfo()
    }

    private fun collectUserInfo() {
        mainViewModel.userInfo.flowWithLifecycle(lifecycle).onEach { userEntity ->
            userEntity?.let { userInfo ->
                with(binding) {
                    tvMyPageMbti.text = userInfo.mbti
                    tvMyPageNickname.text = userInfo.nickname
                    tvMyPageId.text =
                        getString(org.sopt.now.designsystem.R.string.my_page_id, userInfo.id)
                }
            }
        }.launchIn(lifecycleScope)
    }
}