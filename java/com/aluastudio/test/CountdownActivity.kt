package com.aluastudio.test

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CountdownActivity : AppCompatActivity() {

    private lateinit var countdownView: CircularCountdownView
    private lateinit var btnReset: Button
    private var timer: CountDownTimer? = null
    private var totalMillis: Long = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countdown)

        initViews()
        getIntentData()
        startCountdown()
        setupResetButton()
    }

    private fun initViews() {
        countdownView = findViewById(R.id.circularCountdownView)
        btnReset = findViewById(R.id.btnReset)
    }

    private fun getIntentData() {
        totalMillis = intent.getLongExtra("TOTAL_TIME", 0L)
        if (totalMillis <= 0L) {
            Toast.makeText(this, "Durée invalide", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun startCountdown() {
        countdownView.setTotalTime(totalMillis)
        countdownView.start()

        timer = object : CountDownTimer(totalMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                countdownView.updateTime(millisUntilFinished)
            }

            override fun onFinish() {
                countdownView.updateTime(0)
                Toast.makeText(this@CountdownActivity, "Terminé !", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }

    private fun setupResetButton() {
        btnReset.setOnClickListener {
            timer?.cancel()
            finish() // Retour à MainActivity
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }
}
