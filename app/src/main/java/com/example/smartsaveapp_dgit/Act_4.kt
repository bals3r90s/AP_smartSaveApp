package com.example.smartsaveapp_dgit

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.util.Log
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Act_4 : AppCompatActivity() {
    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var totalAmountEditText: EditText
    private lateinit var monthlyRateEditText: EditText
    private lateinit var purposeEditText: EditText
    private lateinit var database: AppDatabase
    private val uiScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gui_4)

        spinner1 = findViewById(R.id.spinner1)
        spinner2 = findViewById(R.id.spinner2)
        totalAmountEditText = findViewById(R.id.bic)
        monthlyRateEditText = findViewById(R.id.amountEditText)
        purposeEditText = findViewById(R.id.verwendungszweck)

        val btn_abbrechen = findViewById<Button>(R.id.cancelButton)
        val btn_weiter = findViewById<Button>(R.id.saveButton)
        val addAccountButton1 = findViewById<Button>(R.id.button_add_AuszahlungKonto)
        val addAccountButton2 = findViewById<Button>(R.id.button_add_ZielKonto)

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app_database"
        ).build()

        loadAccounts()

        addAccountButton1.setOnClickListener {
            startActivity(Intent(this, Act_7::class.java))
        }

        addAccountButton2.setOnClickListener {
            startActivity(Intent(this, Act_7::class.java))
        }

        btn_weiter.setOnClickListener {
            val intent = Intent(this, Act_5::class.java).apply {
                putExtra("account_from", spinner1.selectedItem.toString())
                putExtra("account_to", spinner2.selectedItem.toString())
                putExtra("total_amount", totalAmountEditText.text.toString())
                putExtra("monthly_rate", monthlyRateEditText.text.toString())
                putExtra("purpose", purposeEditText.text.toString())
            }
            startActivity(intent)
        }

        btn_abbrechen.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun loadAccounts() {
        uiScope.launch {
            try {
                val accounts = withContext(Dispatchers.IO) { database.accountDao().getAllAccounts() }
                accounts?.let {
                    val accountList = it.mapNotNull { account -> account.kontoNr.takeIf { it.isNotEmpty() } }
                    val adapter = ArrayAdapter(this@Act_4, android.R.layout.simple_spinner_item, accountList)
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinner1.adapter = adapter
                    spinner2.adapter = adapter
                }
            } catch (e: Exception) {
                Log.e("Act_4", "Fehler beim Laden der Konten", e)
            }
        }
    }
}
