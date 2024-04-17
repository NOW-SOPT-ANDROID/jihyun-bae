package com.sopt.now.feature.ui.main.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sopt.now.domain.model.FakeRepoEntity
import com.sopt.now.feature.databinding.ItemListFakeRepoBinding

class FakeRepoViewHolder(
    private val binding: ItemListFakeRepoBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(fakeRepoEntity: FakeRepoEntity) {
        with(binding) {
            tvListFakeRepoName.text = fakeRepoEntity.name
            tvListFakeRepoDescription.text = fakeRepoEntity.description
            tvListFakeRepoDescription.visibility =
                if (fakeRepoEntity.description.isNullOrEmpty()) View.GONE else View.VISIBLE
        }
    }
}