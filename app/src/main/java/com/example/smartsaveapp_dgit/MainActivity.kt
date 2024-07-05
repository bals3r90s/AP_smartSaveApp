package com.example.smartsaveapp_dgit

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {

    lateinit var kontoButton: TextView
    lateinit var addButton: Button
    lateinit var sparzielButton_4: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        kontoButton = findViewById<TextView>(R.id.textView17)
        sparzielButton_4 = findViewById<Button>(R.id.button_Sparziel)
        addButton = findViewById<Button>(R.id.buttonAdd)

        val items = listOf(
            ItemData(" Auto", "37 %", R.drawable.schwein),
            ItemData("Urlaub", "50 %", R.drawable.schwein),
            ItemData("Möbel", "75 %", R.drawable.schwein),
            ItemData("Telefon", "20 %", R.drawable.schwein),
            ItemData("Motorrad", "90 %", R.drawable.schwein),
            ItemData("Wohnung", "42 %", R.drawable.schwein)

        )

        // Zugriff auf das ListView-Element
        val listView: ListView = findViewById(R.id.listView)

        // Erstellung des benutzerdefinierten Adapters
        val adapter = ListItemAdapter(this, items)

        // Zuweisung des Adapters zum ListView
        listView.adapter = adapter



        kontoButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, Act_2::class.java)
                startActivity(intent)
            }
        })



        sparzielButton_4.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, Act_4::class.java)
                startActivity(intent)
            }
        })
        addButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, Act_1a::class.java)
                startActivity(intent)
            }


        })
    }
}