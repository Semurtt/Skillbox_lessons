package com.example.m3_components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.m3_components.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var time: Float = 20.0F
        var step: Float = 100 / time
        var lastTime: Float = time
        var currentProgress = 100.0




        runBlocking(Dispatchers.Main) {

            launch(Dispatchers.Main) {
                binding.slider.addOnChangeListener { _, value, _ ->
                    time = value + 1
                    lastTime = value
                    step = 100 / value
                    currentProgress = 100.0 + step
                }
            }

            launch(Dispatchers.Main) {
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
            }
        }

    }
}