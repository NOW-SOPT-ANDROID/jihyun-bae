package com.sopt.now.feature.ui.main.home.friend.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sopt.now.domain.model.ProfileEntity
import com.sopt.now.feature.databinding.ItemHomeFriendProfileBinding

class FriendProfileViewHolder(
    private val binding: ItemHomeFriendProfileBinding,
    private val showDeleteProfileDialog: (ProfileEntity) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(profileEntity: ProfileEntity) {
        with(binding) {
            ivHomeFriendProfile.load(profileEntity.profileImage)
            tvHomeFriendProfileName.text = profileEntity.name
            tvHomeFriendProfileDescription.text = profileEntity.selfDescription
            tvHomeFriendProfileDescription.visibility =
                if (profileEntity.selfDescription.isNullOrEmpty()) View.GONE else View.VISIBLE

            root.setOnLongClickListener {
                showDeleteProfileDialog(profileEntity)
                return@setOnLongClickListener true
            }
        }
    }
}