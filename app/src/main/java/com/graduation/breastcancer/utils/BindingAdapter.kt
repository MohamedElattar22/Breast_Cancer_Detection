package com.graduation.breastcancer.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("app:Error")
fun bindErrorOnTextField(
    textInputLayout: TextInputLayout, errorMessage: String?
) {
    if (!textInputLayout.isEnabled)
    {
       return
    }
    errorMessage?.let {
        textInputLayout.error = errorMessage
    }
}
@BindingAdapter("app:GenderError")
fun bindOnGenderError(
    textView: TextView, errorMessage: String?
) {
    textView.text = errorMessage
}