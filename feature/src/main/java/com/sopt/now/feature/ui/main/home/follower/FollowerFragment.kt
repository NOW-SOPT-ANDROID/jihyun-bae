package com.sopt.now.feature.ui.main.home.follower

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.sopt.now.coreui.base.BindingFragment
import com.sopt.now.coreui.util.view.UiState
import com.sopt.now.feature.databinding.FragmentFollowerBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class FollowerFragment :
    BindingFragment<FragmentFollowerBinding>({ FragmentFollowerBinding.inflate(it) }) {
    private val followerViewModel by viewModels<FollowerViewModel>()
    private val followerAdapter by lazy { FollowerAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLayout()
        collectGetReqresListUserState()
    }

    override fun onDestroyView() {
        binding.rvFollower.adapter = null
        super.onDestroyView()
    }

    private fun initLayout() {
        followerViewModel.getReqresListUsers()
        binding.rvFollower.adapter = followerAdapter
    }

    private fun collectGetReqresListUserState() {
        followerViewModel.getReqresListUserState.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { reqresListUserState ->
                when (reqresListUserState) {
                    is UiState.Success -> {
                        followerAdapter.submitList(reqresListUserState.data)
                    }

                    else -> Unit
                }
            }.launchIn(viewLifecycleOwner.lifecycleScope)
    }
}