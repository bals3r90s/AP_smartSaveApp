package com.example.smartsaveapp_dgit

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Act_12 : AppCompatActivity() {

    lateinit var newButton: Button
    lateinit var sparzielButton_4: Button

    private lateinit var listView: ListView
    private lateinit var adapter: KategorrieAdapter
    private lateinit var addButton: Button
    private lateinit var inputText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gui_12)

        listView = findViewById(R.id.listView)
        addButton = findViewById(R.id.addButton)
        inputText = findViewById(R.id.bemerkung)

        val items = mutableListOf("Wohnen", "Transport", "Telefon", "Freizeit")
        adapter = KategorrieAdapter(this, items)
        listView.adapter = adapter

        addButton.setOnClickListener {
            val newItem = inputText.text.toString()
            if (newItem.isNotEmpty()) {
                adapter.addItem(newItem)
                inputText.text.clear()
            }
        }

        sparzielButton_4 = findViewById<Button>(R.id.cancelButton)


        sparzielButton_4.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        })



    }


}