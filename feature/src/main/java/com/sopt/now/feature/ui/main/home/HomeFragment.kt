package com.sopt.now.feature.ui.main.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.sopt.now.component.SoptDialogFragment
import com.sopt.now.coreui.base.BindingFragment
import com.sopt.now.coreui.util.view.ScrollableView
import com.sopt.now.feature.databinding.FragmentHomeBinding
import com.sopt.now.feature.ui.main.home.dialog.HomeAddProfileDialogFragment
import com.sopt.now.feature.ui.main.home.recyclerview.ProfileAdapter
import com.sopt.now.type.DialogType

class HomeFragment : BindingFragment<FragmentHomeBinding>({ FragmentHomeBinding.inflate(it) }),
    ScrollableView {
    private val homeViewModel by viewModels<HomeViewModel>()
    private val profileAdapter by lazy { ProfileAdapter(showDeleteProfileDialog = ::showDeleteProfileDialog) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        initFabHomeAddFriendClickListener()
    }

    override fun scrollToTop() {
        binding.rvHome.smoothScrollToPosition(FIRST_POSITION)
    }

    private fun initAdapter() {
        binding.rvHome.adapter = profileAdapter
        profileAdapter.submitList(homeViewModel.mockProfileList)
    }

    private fun initFabHomeAddFriendClickListener() {
        binding.fabHomeAddFriend.setOnClickListener {
            showAddProfileDialog()
        }
    }

    private fun showDeleteProfileDialog() {
        SoptDialogFragment(
            dialogType = DialogType.DELETE_PROFILE,
        ).show(childFragmentManager, DELETE_PROFILE_DIALOG)
    }

    private fun showAddProfileDialog() {
        HomeAddProfileDialogFragment(
        ).show(childFragmentManager, ADD_PROFILE_DIALOG)
    }

    companion object {
        private const val FIRST_POSITION = 0
        private const val DELETE_PROFILE_DIALOG = "deleteProfileDialog"
        private const val ADD_PROFILE_DIALOG = "addProfileDialog"
    }
}