package com.sopt.now.feature.ui.main.home.follower

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sopt.now.domain.model.ReqresUserEntity
import com.sopt.now.feature.databinding.ItemHomeFriendProfileBinding

class FollowerViewHolder(
    private val binding: ItemHomeFriendProfileBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(reqresUserEntity: ReqresUserEntity) {
        with(binding) {
            ivHomeFriendProfile.load(reqresUserEntity.avatar)
            tvHomeFriendProfileName.text = reqresUserEntity.lastName
            tvHomeFriendProfileDescription.text = reqresUserEntity.email
        }
    }
}