package com.sopt.now.component

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.sopt.now.coreui.base.BindingDialogFragment
import com.sopt.now.coreui.util.fragment.stringOf
import com.sopt.now.type.DialogType
import org.sopt.now.designsystem.databinding.DialogSoptBinding

class SoptDialogFragment(
    private val dialogType: DialogType = DialogType.LOGOUT,
    private val clickLeftBtn: () -> Unit = {},
    private val clickRightBtn: () -> Unit = {},
    private val onDialogClosed: () -> Unit = {}
) : BindingDialogFragment<DialogSoptBinding>({ DialogSoptBinding.inflate(it) }) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLayout()
        addListeners()
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        onDialogClosed()
    }

    private fun initLayout() {
        with(binding) {
            ivSoptDialogIcon.setImageDrawable(context?.let {
                ContextCompat.getDrawable(
                    it,
                    dialogType.icon
                )
            })
            tvSoptDialogTitle.text = stringOf(dialogType.title)
            tvNowDialogDescription.text = stringOf(dialogType.description)
            btnSoptDialogLeft.text = stringOf(dialogType.leftBtnText)
            btnSoptDialogRight.text = stringOf(dialogType.rightBtnText)
        }
    }

    private fun addListeners() {
        binding.btnSoptDialogLeft.setOnClickListener {
            clickLeftBtn()
            dismiss()
        }

        binding.btnSoptDialogRight.setOnClickListener {
            clickRightBtn()
            dismiss()
        }
    }
}