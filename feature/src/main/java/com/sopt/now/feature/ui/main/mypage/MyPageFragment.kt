package com.sopt.now.feature.ui.main.mypage

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.sopt.now.component.SoptDialogFragment
import com.sopt.now.coreui.base.BindingFragment
import com.sopt.now.coreui.util.view.UiState
import com.sopt.now.feature.databinding.FragmentMyPageBinding
import com.sopt.now.feature.ui.signin.SignInActivity
import com.sopt.now.type.DialogType
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.sopt.now.designsystem.R

@AndroidEntryPoint
class MyPageFragment :
    BindingFragment<FragmentMyPageBinding>({ FragmentMyPageBinding.inflate(it) }) {
    private val mainViewModel by viewModels<MyPageViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.fetchUserId()
        setLogoutTvClickListeners()
        collectUserId()
        collectGetUserInfoState()
    }

    private fun setLogoutTvClickListeners() {
        binding.tvMyPageLogout.setOnClickListener {
            showLogoutDialog()
        }
    }

    private fun collectUserId() {
        mainViewModel.userId.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { userId ->
                userId?.let { mainViewModel.getUserInfo(memberId = it) }
            }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun collectGetUserInfoState() {
        mainViewModel.getUserInfoState.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { uiState ->
                when (uiState) {
                    is UiState.Success -> {
                        uiState.data?.let { soptUserInfoEntity ->
                            with(binding) {
                                tvMyPagePhone.text = soptUserInfoEntity.phone
                                tvMyPageNickname.text = soptUserInfoEntity.nickname
                                tvMyPageId.text =
                                    getString(
                                        R.string.my_page_id,
                                        soptUserInfoEntity.authenticationId
                                    )
                            }
                        }
                    }

                    else -> Unit
                }
            }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun showLogoutDialog() {
        SoptDialogFragment(
            dialogType = DialogType.LOGOUT,
            clickLeftBtn = {
                mainViewModel.logout()
                navigateToSignIn()
            }
        ).show(childFragmentManager, LOGOUT_DIALOG)
    }

    private fun navigateToSignIn() {
        Intent(requireContext(), SignInActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(this)
        }
    }

    companion object {
        const val LOGOUT_DIALOG = "logoutDialog"
    }
}