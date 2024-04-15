package com.sopt.now.feature.ui.main.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.sopt.now.coreui.base.BindingFragment
import com.sopt.now.coreui.util.view.ScrollableView
import com.sopt.now.feature.databinding.FragmentHomeBinding

class HomeFragment : BindingFragment<FragmentHomeBinding>({ FragmentHomeBinding.inflate(it) }), ScrollableView {
    private val homeViewModel by viewModels<HomeViewModel>()
    private val profileAdapter by lazy { ProfileAdapter() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
    }

    override fun scrollToTop() {
       binding.rvHome.smoothScrollToPosition(FIRST_POSITION)
    }

    private fun initAdapter() {
        binding.rvHome.adapter = profileAdapter
        profileAdapter.submitList(homeViewModel.mockProfileList)
    }

    companion object {
        private const val FIRST_POSITION = 0
    }
}