package com.sopt.now.feature.ui.main.home.friend.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sopt.now.domain.model.ProfileModel
import com.sopt.now.feature.databinding.ItemHomeFriendProfileBinding

class FriendProfileViewHolder(
    private val binding: ItemHomeFriendProfileBinding,
    private val showDeleteProfileDialog: (ProfileModel) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(profileModel: ProfileModel) {
        with(binding) {
            ivHomeFriendProfile.load(profileModel.profileImage)
            tvHomeFriendProfileName.text = profileModel.name
            tvHomeFriendProfileDescription.text = profileModel.selfDescription
            tvHomeFriendProfileDescription.visibility =
                if (profileModel.selfDescription.isNullOrEmpty()) View.GONE else View.VISIBLE

            root.setOnLongClickListener {
                showDeleteProfileDialog(profileModel)
                return@setOnLongClickListener true
            }
        }
    }
}