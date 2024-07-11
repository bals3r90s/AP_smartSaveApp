package com.example.smartsaveapp_dgit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
        setContentView(R.layout.gui_7)

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
            val kontoNr = kontoNrEditText.text.toString().trim()
            val blz = blzEditText.text.toString().trim()
            val bic = bicEditText.text.toString().trim()
            val iban = ibanEditText.text.toString().trim()
            val bemerkung = bemerkungEditText.text.toString().trim()
            val kontotyp = when {
                checkBankkonto.isChecked -> "Bankkonto"
                checkSparkonto.isChecked -> "Sparkonto"
                checkKreditkarte.isChecked -> "Kreditkartenkonto"
                else -> ""

            }

            if (kontoNr.isNotEmpty() && blz.isNotEmpty() && bic.isNotEmpty() && iban.isNotEmpty() && kontotyp.isNotEmpty()) {
                val account = Account(
                    kontoNr = kontoNr,
                    blz = blz,
                    bic = bic,
                    iban = iban,
                    bemerkung = bemerkung,
                    kontotyp = kontotyp
                )

                uiScope.launch {
                    withContext(Dispatchers.IO) {
                        database.accountDao().insert(account)
                    }
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            } else {
                Log.e("Act_7", "Fehler: Alle Felder müssen ausgefüllt werden.")
            }
        }

        checkBankkonto.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkSparkonto.isChecked = false
                checkKreditkarte.isChecked = false
            }
        }

        checkSparkonto.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkBankkonto.isChecked = false
                checkKreditkarte.isChecked = false
            }
        }

        checkKreditkarte.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkBankkonto.isChecked = false
                checkSparkonto.isChecked = false
            }
        }

        abbrechenButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
    }
}
