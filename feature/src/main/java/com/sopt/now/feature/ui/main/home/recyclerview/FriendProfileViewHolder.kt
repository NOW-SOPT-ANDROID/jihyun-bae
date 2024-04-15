package com.sopt.now.feature.ui.main.home.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sopt.now.feature.databinding.ItemHomeFriendProfileBinding
import com.sopt.now.feature.model.ProfileModel

class FriendProfileViewHolder(
    private val binding: ItemHomeFriendProfileBinding,
    private val showDeleteProfileDialog: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.root.setOnLongClickListener {
            showDeleteProfileDialog()
            return@setOnLongClickListener true
        }
    }

    fun onBind(profileModel: ProfileModel) {
        with(binding) {
            ivHomeFriendProfile.load(profileModel.profileImage)
            tvHomeFriendProfileName.text = profileModel.name
            tvHomeFriendProfileDescription.text = profileModel.selfDescription
            tvHomeFriendProfileDescription.visibility =
                if (profileModel.selfDescription.isNullOrEmpty()) View.GONE else View.VISIBLE
        }
    }
}