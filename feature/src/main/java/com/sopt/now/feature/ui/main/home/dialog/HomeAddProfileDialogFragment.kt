package com.sopt.now.feature.ui.main.home.dialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import com.sopt.now.coreui.base.BindingDialogFragment
import com.sopt.now.domain.model.ProfileEntity
import com.sopt.now.feature.databinding.DialogHomeAddProfileBinding

class HomeAddProfileDialogFragment(
    private val clickSubmitBtn: (ProfileEntity) -> Unit = {},
    private val onDialogClosed: () -> Unit = {}
) : BindingDialogFragment<DialogHomeAddProfileBinding>({ DialogHomeAddProfileBinding.inflate(it) }) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addListeners()
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        onDialogClosed()
    }

    private fun addListeners() {
        with(binding) {
            btnDialogHomeAddProfileSubmit.setOnClickListener {
                if (!etDialogHomeAddProfileName.editText.text.isNullOrEmpty()) {
                    clickSubmitBtn(
                        ProfileEntity(
                            name = etDialogHomeAddProfileName.editText.text.toString(),
                            selfDescription = etDialogHomeAddProfileSelfDescription.editText.text.toString()
                        )
                    )
                    dismiss()
                }
            }
        }
    }
}