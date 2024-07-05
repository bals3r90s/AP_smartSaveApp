package com.example.smartsaveapp_dgit

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class Act_2 : AppCompatActivity() {

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gui_2)



        val btn_abbrechen = findViewById<Button>(R.id.cancelButton)
        btn_abbrechen.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        })

    }


}