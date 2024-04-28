package com.sopt.now.feature.ui.main.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.sopt.now.component.SoptDialogFragment
import com.sopt.now.coreui.base.BindingFragment
import com.sopt.now.coreui.util.view.ScrollableView
import com.sopt.now.coreui.util.view.UiState
import com.sopt.now.domain.model.ProfileEntity
import com.sopt.now.feature.databinding.FragmentHomeBinding
import com.sopt.now.feature.ui.main.home.dialog.HomeAddProfileDialogFragment
import com.sopt.now.feature.ui.main.home.recyclerview.ProfileAdapter
import com.sopt.now.type.DialogType
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class HomeFragment : BindingFragment<FragmentHomeBinding>({ FragmentHomeBinding.inflate(it) }),
    ScrollableView {
    private val homeViewModel by viewModels<HomeViewModel>()
    private val profileAdapter by lazy { ProfileAdapter(showDeleteProfileDialog = ::showDeleteProfileDialog) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLayout()
        initFabHomeAddFriendClickListener()
        collectProfileListState()
    }

    override fun scrollToTop() {
        binding.rvHome.smoothScrollToPosition(FIRST_POSITION)
    }

    private fun initLayout() {
        homeViewModel.getProfileList()
        binding.rvHome.adapter = profileAdapter
    }

    private fun initFabHomeAddFriendClickListener() {
        binding.fabHomeAddFriend.setOnClickListener {
            showAddProfileDialog()
        }
    }

    private fun collectProfileListState() {
        homeViewModel.profileListState.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { profileListState ->
                when (profileListState) {
                    is UiState.Success -> {
                        profileAdapter.submitList(profileListState.data)
                    }

                    else -> Unit
                }
            }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun showDeleteProfileDialog(profileEntity: ProfileEntity) {
        SoptDialogFragment(
            dialogType = DialogType.DELETE_PROFILE,
            clickLeftBtn = {
                homeViewModel.deleteProfile(profile = profileEntity)
            }
        ).show(childFragmentManager, DELETE_PROFILE_DIALOG)
    }

    private fun showAddProfileDialog() {
        HomeAddProfileDialogFragment(
            clickSubmitBtn = { profileEntity ->
                homeViewModel.insertProfile(profileEntity)
            }
        ).show(childFragmentManager, ADD_PROFILE_DIALOG)
    }

    companion object {
        private const val FIRST_POSITION = 0
        private const val DELETE_PROFILE_DIALOG = "deleteProfileDialog"
        private const val ADD_PROFILE_DIALOG = "addProfileDialog"
    }
}