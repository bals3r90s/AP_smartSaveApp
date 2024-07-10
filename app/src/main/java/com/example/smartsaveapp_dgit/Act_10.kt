package com.example.smartsaveapp_dgit

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class Act_10 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gui_10)







        val btn_abbrechen = findViewById<Button>(R.id.cancelButton)
        btn_abbrechen.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        })

        val btn_add = findViewById<Button>(R.id.buttonAdd)
        btn_add.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, Act_9::class.java)
                startActivity(intent)
            }
        })

    }


}