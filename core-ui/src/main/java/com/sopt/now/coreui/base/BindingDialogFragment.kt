package com.sopt.now.coreui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding

abstract class BindingDialogFragment<T : ViewBinding>(private val inflater: (LayoutInflater) -> T) :
    DialogFragment() {
    private var _binding: T? = null
    val binding get() = requireNotNull(_binding) { "${this::class.java.simpleName}에서 에러가 발생했습니다." }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflater(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(true)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}