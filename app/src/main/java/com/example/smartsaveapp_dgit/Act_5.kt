package com.example.smartsaveapp_dgit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Act_5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gui_5)


        val accountFrom = intent.getStringExtra("account_from")
        val accountTo = intent.getStringExtra("account_to")
        val totalAmount = intent.getStringExtra("total_amount")
        val monthlyRate = intent.getStringExtra("monthly_rate")
        val purpose = intent.getStringExtra("purpose")


        findViewById<TextView>(R.id.textView7).text = accountFrom
        findViewById<TextView>(R.id.textView8).text = accountTo
        findViewById<TextView>(R.id.textView9).text = monthlyRate
        findViewById<TextView>(R.id.textView10).text = "Gesamtbetrag"
        findViewById<TextView>(R.id.textView12).text = totalAmount



        val btn_abbrechen = findViewById<Button>(R.id.cancelButton)
        btn_abbrechen.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }

        val btn_weiter = findViewById<Button>(R.id.saveButton)
        btn_weiter.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
    }
}
