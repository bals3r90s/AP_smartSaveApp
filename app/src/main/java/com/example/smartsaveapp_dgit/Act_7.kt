package com.example.smartsaveapp_dgit

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Act_7 : AppCompatActivity() {

    private lateinit var kontoNrEditText: EditText
    private lateinit var blzEditText: EditText
    private lateinit var bicEditText: EditText
    private lateinit var ibanEditText: EditText
    private lateinit var bemerkungEditText: EditText
    private lateinit var checkBankkonto: CheckBox
    private lateinit var checkSparkonto: CheckBox
    private lateinit var checkKreditkarte: CheckBox
    private lateinit var speichernButton: Button
    private lateinit var abbrechenButton: Button
    private lateinit var database: AppDatabase
    private val uiScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gui_7) // Dein bestehendes Layout

        kontoNrEditText = findViewById(R.id.kontoNr)
        blzEditText = findViewById(R.id.blz)
        bicEditText = findViewById(R.id.bic)
        ibanEditText = findViewById(R.id.iban)
        bemerkungEditText = findViewById(R.id.bemerkung)
        checkBankkonto = findViewById(R.id.checkBankkonto)
        checkSparkonto = findViewById(R.id.checkSparkonto)
        checkKreditkarte = findViewById(R.id.checkKreditkarte)
        speichernButton = findViewById(R.id.saveButton)
        abbrechenButton = findViewById(R.id.cancelButton)

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app_database"
        ).build()

        speichernButton.setOnClickListener {
            val kontoNr = kontoNrEditText.text.toString()
            val blz = blzEditText.text.toString()
            val bic = bicEditText.text.toString()
            val iban = ibanEditText.text.toString()
            val bemerkung = bemerkungEditText.text.toString()
            val kontotyp = when {
                checkBankkonto.isChecked -> "Bankkonto"
                checkSparkonto.isChecked -> "Sparkonto"
                checkKreditkarte.isChecked -> "Kreditkartenkonto"
                else -> ""
            }

            val account = Account(
                kontoNr = kontoNr,
                blz = blz,
                bic = bic,
                iban = iban,
                bemerkung = bemerkung,
                kontotyp = kontotyp
            )

            uiScope.launch {
                database.accountDao().insert(account)
                finish()
            }
        }

        abbrechenButton.setOnClickListener {
            finish()
        }
    }
}
