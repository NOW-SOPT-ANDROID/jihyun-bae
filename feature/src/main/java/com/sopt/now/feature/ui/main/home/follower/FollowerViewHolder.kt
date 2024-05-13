package com.sopt.now.feature.ui.main.home.follower

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sopt.now.domain.model.ReqresUserModel
import com.sopt.now.feature.databinding.ItemHomeFriendProfileBinding

class FollowerViewHolder(
    private val binding: ItemHomeFriendProfileBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(reqresUserModel: ReqresUserModel) {
        with(binding) {
            ivHomeFriendProfile.load(reqresUserModel.avatar)
            tvHomeFriendProfileName.text = reqresUserModel.lastName
            tvHomeFriendProfileDescription.text = reqresUserModel.email
        }
    }
}