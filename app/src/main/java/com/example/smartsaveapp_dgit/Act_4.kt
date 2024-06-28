package com.example.smartsaveapp_dgit

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class Act_4 : AppCompatActivity() {

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gui_4)

        spinner1 = findViewById(R.id.spinner1)
        spinner2 = findViewById(R.id.spinner2)

        val options = listOf("Option 1", "Option 2", "Option 3", "Option 4")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1.adapter = adapter
        spinner2.adapter = adapter




        val btn_abbrechen = findViewById<Button>(R.id.cancelButton)
        btn_abbrechen.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        })
        val btn_weiter = findViewById<Button>(R.id.saveButton)
        btn_weiter.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, Act_5::class.java)
                startActivity(intent)
            }
        })


        val addAuszahlung = findViewById<Button>(R.id.button_add_AuszahlungKonto)
        addAuszahlung.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, Act_4a::class.java)
                startActivity(intent)
            }
        })

        val addZielkonto = findViewById<Button>(R.id.button_add_ZielKonto)
        addZielkonto.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, Act_4a::class.java)
                startActivity(intent)
            }
        })

    }


}