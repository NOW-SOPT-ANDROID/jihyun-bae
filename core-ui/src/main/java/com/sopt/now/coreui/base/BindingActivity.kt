package com.sopt.now.coreui.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BindingActivity<T : ViewBinding>(private val inflater: (LayoutInflater) -> T) :
    AppCompatActivity() {
    lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflater(layoutInflater)
        setContentView(binding.root)
    }
}