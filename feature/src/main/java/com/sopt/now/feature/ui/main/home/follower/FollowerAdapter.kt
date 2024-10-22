package com.sopt.now.feature.ui.main.home.follower

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.sopt.now.coreui.util.view.ItemDiffCallback
import com.sopt.now.domain.model.ReqresUserModel
import com.sopt.now.feature.databinding.ItemHomeFriendProfileBinding

class FollowerAdapter() : ListAdapter<ReqresUserModel, FollowerViewHolder>(
    ItemDiffCallback<ReqresUserModel>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.id == new.id }
    )
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder =
        FollowerViewHolder(
            binding = ItemHomeFriendProfileBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(reqresUserModel = currentList[position])
    }
}