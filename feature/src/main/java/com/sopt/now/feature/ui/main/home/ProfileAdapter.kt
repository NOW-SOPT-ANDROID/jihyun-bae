package com.sopt.now.feature.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.now.coreui.util.view.ItemDiffCallback
import com.sopt.now.feature.databinding.ItemHomeFriendProfileBinding
import com.sopt.now.feature.databinding.ItemHomeMyProfileBinding
import com.sopt.now.feature.model.ProfileModel

class ProfileAdapter() : ListAdapter<ProfileModel, RecyclerView.ViewHolder>(
    ItemDiffCallback<ProfileModel>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.name == new.name }
    )
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            VIEW_TYPE_MY_PROFILE -> {
                MyProfileViewHolder(
                    ItemHomeMyProfileBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> {
                FriendProfileViewHolder(
                    ItemHomeFriendProfileBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MyProfileViewHolder -> holder.onBind(currentList[position])
            is FriendProfileViewHolder -> holder.onBind(currentList[position])
        }
    }

    override fun getItemViewType(position: Int): Int = when (position) {
        FIRST_POSITION -> VIEW_TYPE_MY_PROFILE
        else -> VIEW_TYPE_FRIEND_PROFILE
    }

    companion object {
        private const val FIRST_POSITION = 0
        private const val VIEW_TYPE_MY_PROFILE = 0
        private const val VIEW_TYPE_FRIEND_PROFILE = 1
    }
}