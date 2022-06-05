package com.example.m1_hello_world

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.m1_hello_world.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var count = 0
        val totalSpace = 50
        binding.passengers.text = count.toString()
        binding.leftSpace.text = "Все места свободны"

        fun checkQuantity() {
            if (count < 1) {
                count = 0
                binding.leftSpace.setTextColor(getColor(R.color.green))
                binding.leftSpace.text = "Все места свободны"
            } else if (count > totalSpace - 1) {
                count = totalSpace
                binding.resetButton.visibility = View.VISIBLE
                binding.leftSpace.setTextColor(getColor(R.color.red))
                binding.leftSpace.text = "Пассажиров слишком много!"
            } else {
                binding.leftSpace.setTextColor(getColor(R.color.blue))
                binding.leftSpace.text = "Мест осталось: ${totalSpace - count}"
                binding.resetButton.visibility = View.INVISIBLE
            }
            binding.passengers.text = count.toString()
        }

        binding.plusButton.setOnClickListener {
            count++
            checkQuantity()
        }

        binding.minusButton.setOnClickListener {
            count--
            checkQuantity()
        }

        binding.resetButton.setOnClickListener {
            count = 0
            binding.resetButton.visibility = View.INVISIBLE
            binding.passengers.text = count.toString()
            binding.leftSpace.setTextColor(getColor(R.color.green))
            binding.leftSpace.text = "Все места свободны"
        }


    }
}