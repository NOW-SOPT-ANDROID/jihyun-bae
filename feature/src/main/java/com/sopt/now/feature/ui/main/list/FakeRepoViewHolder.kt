package com.sopt.now.feature.ui.main.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sopt.now.domain.model.FakeRepoModel
import com.sopt.now.feature.databinding.ItemListFakeRepoBinding

class FakeRepoViewHolder(
    private val binding: ItemListFakeRepoBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(fakeRepoModel: FakeRepoModel) {
        with(binding) {
            tvListFakeRepoName.text = fakeRepoModel.name
            tvListFakeRepoDescription.text = fakeRepoModel.description
            tvListFakeRepoDescription.visibility =
                if (fakeRepoModel.description.isNullOrEmpty()) View.GONE else View.VISIBLE
        }
    }
}