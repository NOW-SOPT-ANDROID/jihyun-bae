package com.sopt.now.feature.ui.main.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.sopt.now.coreui.base.BindingFragment
import com.sopt.now.feature.databinding.FragmentHomeBinding

class HomeFragment : BindingFragment<FragmentHomeBinding>({ FragmentHomeBinding.inflate(it) }) {
    private val homeViewModel by viewModels<HomeViewModel>()
    private val profileAdapter by lazy { ProfileAdapter() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
    }

    private fun initAdapter() {
        binding.rvHome.adapter = profileAdapter
        profileAdapter.submitList(homeViewModel.mockProfileList)
    }
}