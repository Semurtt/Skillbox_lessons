package com.example.m2_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.m2_layout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val text1 = "Верхняя строчка, настроенная из кода"
        val text2 = "Нижняя строчка, настроенная из кода"
        binding.customViewInActivity.set1Text(text1)
        binding.customViewInActivity.set2Text(text2)
//test for IDE via ssh
    }
}