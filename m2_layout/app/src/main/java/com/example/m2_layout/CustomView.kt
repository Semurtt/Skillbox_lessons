package com.example.m2_layout

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.m2_layout.databinding.CustomViewBinding


class CustomView
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding = CustomViewBinding.inflate(LayoutInflater.from(context))

    init {
        addView(binding.root)
    }

    fun set1Text(text1: String) {
        binding.firstText.text = text1
    }

    fun set2Text(text2: String) {
        binding.secondText.text = text2
    }

}