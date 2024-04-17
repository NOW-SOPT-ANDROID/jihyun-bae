package com.sopt.now.feature.ui.main.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.sopt.now.coreui.base.BindingFragment
import com.sopt.now.coreui.util.view.UiState
import com.sopt.now.feature.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ListFragment : BindingFragment<FragmentListBinding>({ FragmentListBinding.inflate(it) }) {
    private val listViewModel by viewModels<ListViewModel>()
    private val fakeRepoAdapter by lazy { FakeRepoAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLayout()
        collectFakeRepoListState()
    }

    private fun initLayout() {
        listViewModel.getFakeRepoList()
        binding.rvList.adapter = fakeRepoAdapter
    }

    private fun collectFakeRepoListState() {
        listViewModel.fakeRepoListState.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { fakeRepoLIstState ->
                when (fakeRepoLIstState) {
                    is UiState.Success -> {
                        fakeRepoAdapter.submitList(fakeRepoLIstState.data)
                    }

                    else -> Unit
                }
            }.launchIn(viewLifecycleOwner.lifecycleScope)
    }
}