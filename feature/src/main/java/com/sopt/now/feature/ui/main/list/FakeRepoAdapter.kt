package com.sopt.now.feature.ui.main.list


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.sopt.now.coreui.util.view.ItemDiffCallback
import com.sopt.now.domain.model.FakeRepoEntity
import com.sopt.now.feature.databinding.ItemListFakeRepoBinding

class FakeRepoAdapter() : ListAdapter<FakeRepoEntity, FakeRepoViewHolder>(
    ItemDiffCallback<FakeRepoEntity>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.id == new.id }
    )
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FakeRepoViewHolder =
        FakeRepoViewHolder(
            binding = ItemListFakeRepoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: FakeRepoViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }
}