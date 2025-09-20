package com.aluastudio.test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var npHours: NumberPicker
    private lateinit var npMinutes: NumberPicker
    private lateinit var npSeconds: NumberPicker
    private lateinit var btnStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupNumberPickers()
        setupStartButton()
    }

    private fun initViews() {
        npHours = findViewById(R.id.npHours)
        npMinutes = findViewById(R.id.npMinutes)
        npSeconds = findViewById(R.id.npSeconds)
        btnStart = findViewById(R.id.btnStart)
    }

    private fun setupNumberPickers() {
        npHours.apply {
            minValue = 0
            maxValue = 99
        }

        npMinutes.apply {
            minValue = 0
            maxValue = 59
        }

        npSeconds.apply {
            minValue = 0
            maxValue = 59
        }
    }

    private fun setupStartButton() {
        btnStart.setOnClickListener {
            val totalMillis = calculateTotalMillis()

            if (totalMillis > 0) {
                val intent = Intent(this, CountdownActivity::class.java)
                intent.putExtra("TOTAL_TIME", totalMillis)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please select a valid time.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun calculateTotalMillis(): Long {
        val hours = npHours.value
        val minutes = npMinutes.value
        val seconds = npSeconds.value
        return ((hours * 3600 + minutes * 60 + seconds) * 1000L)
    }
}
