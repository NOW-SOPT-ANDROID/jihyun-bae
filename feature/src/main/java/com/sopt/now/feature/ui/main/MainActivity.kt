package com.sopt.now.feature.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.sopt.now.component.SoptDialogFragment
import com.sopt.now.coreui.base.BindingActivity
import com.sopt.now.feature.databinding.ActivityMainBinding
import com.sopt.now.feature.ui.signin.SignInActivity
import com.sopt.now.type.DialogType
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel.fetchUserInfo()
        setLogoutTvClickListeners()
        collectUserInfo()
    }

    private fun setLogoutTvClickListeners() {
        binding.tvMyPageLogout.setOnClickListener {
            showLogoutDialog()
        }
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

    private fun showLogoutDialog() {
        SoptDialogFragment(
            dialogType = DialogType.LOGOUT,
            clickLeftBtn = {
                mainViewModel.logout()
                navigateToSignIn()
            }
        ).show(supportFragmentManager, LOGOUT_DIALOG)
    }

    private fun navigateToSignIn() {
        Intent(this@MainActivity, SignInActivity::class.java).apply {
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(this)
            finish()
        }
    }

    companion object {
        const val LOGOUT_DIALOG = "logoutDialog"
    }
}