package com.sopt.now.coreui.util.view


import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getString
import androidx.core.view.ViewCompat
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(message: String, isShort: Boolean = true) {
    val duration = if (isShort) Snackbar.LENGTH_SHORT else Snackbar.LENGTH_LONG
    Snackbar.make(this, message, duration).show()
}

fun View.stringOf(@StringRes resId: Int) = getString(context, resId)

fun View.colorOf(@ColorRes resId: Int) = ContextCompat.getColor(context, resId)

fun View.setBackgroundTint(@ColorRes resId: Int) =
    ViewCompat.setBackgroundTintList(this, ContextCompat.getColorStateList(context, resId))

inline fun View.setOnSingleClickListener(
    delay: Long = 500L,
    crossinline block: (View) -> Unit
) {
    var isClickable = true
    setOnClickListener { view ->
        if (isClickable) {
            isClickable = false
            block(view)
            view.postDelayed({
                isClickable = true
            }, delay)
        }
    }
}