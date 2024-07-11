package com.example.smartsaveapp_dgit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Act_4 : AppCompatActivity() {

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var database: AppDatabase
    private val uiScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gui_4)

        spinner1 = findViewById(R.id.spinner1)
        spinner2 = findViewById(R.id.spinner2)


        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app_database"
        ).build()

        loadAccounts()

        val btn_abbrechen = findViewById<Button>(R.id.cancelButton)
        btn_abbrechen.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
        val btn_weiter = findViewById<Button>(R.id.saveButton)
        btn_weiter.setOnClickListener {
            val intent = Intent(applicationContext, Act_5::class.java)
            startActivity(intent)
        }

        val addAuszahlung = findViewById<Button>(R.id.button_add_AuszahlungKonto)
        addAuszahlung.setOnClickListener {
            val intent = Intent(applicationContext, Act_4a::class.java)
            startActivity(intent)
        }

        val addZielkonto = findViewById<Button>(R.id.button_add_ZielKonto)
        addZielkonto.setOnClickListener {
            val intent = Intent(applicationContext, Act_4a::class.java)
            startActivity(intent)
        }
    }

    private fun loadAccounts() {
        uiScope.launch {
            try {
                val accounts = withContext(Dispatchers.IO) { database.accountDao().getAllAccounts() }
                accounts?.let {
                    val accountList = it.mapNotNull { account -> account.kontoNr.takeIf { it.isNotEmpty() } } // Nur nicht-leere Kontonummern

                    val adapter = ArrayAdapter(this@Act_4, android.R.layout.simple_spinner_item, accountList)
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                    spinner1.adapter = adapter
                    spinner2.adapter = adapter

                    Log.d("Act_4", "Accounts geladen: ${accountList.joinToString(", ")}")
                } ?: run {
                    Log.d("Act_4", "Keine Konten in der Datenbank gefunden")
                }
            } catch (e: Exception) {
                Log.e("Act_4", "Fehler beim Laden der Konten", e)
            }
        }
    }
}
