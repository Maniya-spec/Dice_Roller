package com.example.diceroller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, options::class.java)
            startActivity(intent)
            finish()
        },2500)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        object : CountDownTimer(2500, 1000) { // 10 seconds countdown with 1 second interval
            override fun onTick(millisUntilFinished: Long) {
                val progress = (2500 - millisUntilFinished) / 20 // calculate the progress percentage
                progressBar.progress = progress.toInt()
            }

            override fun onFinish() {
                // do something when the countdown is finished
            }
        }.start()
    }
}