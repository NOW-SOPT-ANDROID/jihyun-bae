package com.sopt.now.component

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import org.sopt.now.designsystem.databinding.EditTextSoptBinding
@SuppressLint("CustomViewStyleable")
class SoptEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding: EditTextSoptBinding
    val editText get() = binding.etEditTextSoptEditText

    init {
        binding = EditTextSoptBinding.inflate(LayoutInflater.from(context), this, true)
    }
}