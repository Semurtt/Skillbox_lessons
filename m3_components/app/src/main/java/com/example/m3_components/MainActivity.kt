package com.example.m3_components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        var isRunning = false

        binding.slider.addOnChangeListener { _, value, _ ->
            time = value
            lastTime = value
            step = 100 / value
            binding.timer.text = time.toInt().toString()
        }

        fun stop() {
            isRunning = false
            time = lastTime
            binding.slider.isEnabled = true
            binding.slider.value = time
            currentProgress = 100.0
            binding.progressBar.progress = currentProgress.toInt()
            binding.timer.text = time.toInt().toString()
            binding.button.text = "СТАРТ"
        }

        val job = CoroutineScope(Dispatchers.Main)

        var countDown: Job? = null

        binding.button.setOnClickListener {
            if (!isRunning) {
                Toast.makeText(baseContext, "Запускаем", Toast.LENGTH_SHORT).show()
                isRunning = true
                binding.slider.isEnabled = false
                binding.button.text = "СТОП"
                binding.timer.text = time.toInt().toString()
                countDown = job.launch {
                    while (time > 0) {
                        delay(1000)
                        time--
                        binding.timer.text = time.toInt().toString()
                        currentProgress -= step
                        binding.progressBar.progress = currentProgress.toInt()
                    }
                    stop()
                    Toast.makeText(baseContext, "Закончили", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(baseContext, "Остановили", Toast.LENGTH_SHORT).show()
                countDown?.cancel()
                stop()
            }
        }


    }
}