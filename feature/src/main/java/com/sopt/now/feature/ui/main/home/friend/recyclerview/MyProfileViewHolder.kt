package com.sopt.now.feature.ui.main.home.friend.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sopt.now.domain.model.ProfileEntity
import com.sopt.now.feature.databinding.ItemHomeMyProfileBinding

class MyProfileViewHolder(
    private val binding: ItemHomeMyProfileBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(profileEntity: ProfileEntity) {
        with(binding) {
            ivHomeMyProfile.load(profileEntity.profileImage)
            tvHomeMyProfileName.text = profileEntity.name
            tvHomeMyProfileDescription.text = profileEntity.selfDescription
            tvHomeMyProfileDescription.visibility =
                if (profileEntity.selfDescription.isNullOrEmpty()) View.GONE else View.VISIBLE
        }
    }
}