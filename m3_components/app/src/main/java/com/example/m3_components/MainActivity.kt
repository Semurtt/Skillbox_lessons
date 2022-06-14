package com.example.m3_components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.m3_components.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var time: Float = 20.0F
        var step: Float = 100 / time
        var lastTime: Float = time
        var currentProgress = 100.0




        CoroutineScope(Dispatchers.Main).launch {

            binding.slider.addOnChangeListener { _, value, _ ->
                time = value
                lastTime = value
                step = 100 / value
                currentProgress = 100.0 + step
            }

                binding.button.setOnClickListener {
                    binding.slider.isEnabled = false
                    binding.button.text = "Запустили"
                    binding.timer.text = time.toInt().toString()
                    launch(Dispatchers.Main) {
                    while (time > 0) {
//                for (i in time.toInt()..0) {
//                        repeat(time.toInt()) {
                        delay(500)
                        time--
                        binding.timer.text = time.toInt().toString()
                        currentProgress -= step
                        binding.progressBar.progress = currentProgress.toInt()
                        binding.button.text = "Цикл работает"
                        }
                    }
                    time--
                    binding.button.text = "temp"
//                    delay(2000)
                    binding.timer.text = time.toInt().toString()
                    currentProgress -= step
                    binding.progressBar.progress = currentProgress.toInt()
                    binding.button.text = "Закончили"
                }


            /*launch {
                while (true) {
                    delay(1000)
                    binding.button.setOnClickListener {
                        if (time > 1) {
                            binding.slider.isEnabled = false
                            binding.button.text = "Идёт"
                            time--
                            binding.timer.text = time.toInt().toString()
                            currentProgress -= step
                            binding.progressBar.progress = currentProgress.toInt()
                        } else {
                            time--
                            binding.timer.text = time.toInt().toString()
                            binding.progressBar.progress = time.toInt()
                            binding.button.text = "Сброс"
                            currentProgress = 100.0 + step
                            time = lastTime + 1
                            binding.slider.isEnabled = true
                        }
                    }
                }
            }*/
        }

    }
}