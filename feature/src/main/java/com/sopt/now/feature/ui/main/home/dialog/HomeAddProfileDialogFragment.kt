package com.sopt.now.feature.ui.main.home.dialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import com.sopt.now.coreui.base.BindingDialogFragment
import com.sopt.now.feature.databinding.DialogHomeAddProfileBinding

class HomeAddProfileDialogFragment(
    private val clickSubmitBtn: () -> Unit = {},
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
        binding.btnDialogHomeAddProfileSubmit.setOnClickListener {
            clickSubmitBtn()
            dismiss()
        }
    }
}