package com.example.smartsaveapp_dgit

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {

    lateinit var gui3: Button
    lateinit var gui4: Button
    lateinit var gui5: Button
    lateinit var addButton: Button
    lateinit var sparzielButton_4: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        sparzielButton_4 = findViewById<Button>(R.id.button_Sparziel)
        addButton = findViewById<Button>(R.id.buttonAdd)

        // Datenquelle für das ListView
        val items = listOf("Element 1", "Element 2", "Element 3", "Element 4", "Element 5")

        // Zugriff auf das ListView-Element
        val listView: ListView = findViewById(R.id.listView)

        // Erstellung des Adapters
        val adapter = ArrayAdapter(this, R.layout.list_item_main, R.id.textView, items)

        // Zuweisung des Adapters zum ListView
        listView.adapter = adapter




/*

        gui3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, Act_3::class.java)
                startActivity(intent)
            }
        })
        gui4.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, Act_4::class.java)
                startActivity(intent)
            }
        })
        gui5.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, Act_11::class.java)
                startActivity(intent)
            }
        })


 */

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