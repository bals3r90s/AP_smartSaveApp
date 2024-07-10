package com.example.smartsaveapp_dgit

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class Act_1a : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gui_main_a)






        val btn_abbrechen = findViewById<Button>(R.id.cancelButton)
        btn_abbrechen.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        })


        val kontoAnlegenButton = findViewById<Button>(R.id.buttonKontoAnlegen)
        kontoAnlegenButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, Act_7::class.java)
                startActivity(intent)
            }
        })

        val umsaetzeVerwaltenButton = findViewById<Button>(R.id.buttonUmsatzVerwaten)
        umsaetzeVerwaltenButton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, Act_10::class.java)
                startActivity(intent)
            }
        })

        val kategorienVerwaltenButton = findViewById<Button>(R.id.buttonKategorienVerwalten)
        kategorienVerwaltenButton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, Act_12::class.java)
                startActivity(intent)
            }
        })





    }


}