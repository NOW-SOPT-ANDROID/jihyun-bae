package com.sopt.now.feature.ui.main.home.friend.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sopt.now.domain.model.ProfileModel
import com.sopt.now.feature.databinding.ItemHomeMyProfileBinding

class MyProfileViewHolder(
    private val binding: ItemHomeMyProfileBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(profileModel: ProfileModel) {
        with(binding) {
            ivHomeMyProfile.load(profileModel.profileImage)
            tvHomeMyProfileName.text = profileModel.name
            tvHomeMyProfileDescription.text = profileModel.selfDescription
            tvHomeMyProfileDescription.visibility =
                if (profileModel.selfDescription.isNullOrEmpty()) View.GONE else View.VISIBLE
        }
    }
}