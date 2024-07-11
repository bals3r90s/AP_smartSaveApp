package com.example.smartsaveapp_dgit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {

    lateinit var kontoButton: TextView
    lateinit var addButton: Button
    lateinit var sparzielButton_4: Button
    lateinit var database: AppDatabase
    private val uiScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        kontoButton = findViewById(R.id.textView17)
        sparzielButton_4 = findViewById(R.id.button_Sparziel)
        addButton = findViewById(R.id.buttonAdd)

        // Initialisiere die Datenbank
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app_database"
        )
            .fallbackToDestructiveMigration()
            .build()

        // Rufe die Methode auf, um Konten zu laden
        loadAccounts()

        val items = listOf(
            ItemData("Auto", "37 %", R.drawable.schwein),
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

        kontoButton.setOnClickListener {
            val intent = Intent(applicationContext, Act_2::class.java)
            startActivity(intent)
        }

        sparzielButton_4.setOnClickListener {
            val intent = Intent(applicationContext, Act_4::class.java)
            startActivity(intent)
        }

        addButton.setOnClickListener {
            val intent = Intent(applicationContext, Act_7::class.java) // Startet die Act_7
            startActivity(intent)
        }
    }

    private fun loadAccounts() {
        Log.d("MainActivity", "loadAccounts aufgerufen")
        uiScope.launch {
            try {
                val accounts = withContext(Dispatchers.IO) { database.accountDao().getAllAccounts() }
                // Hier kannst du die Konten auf irgendeine Weise anzeigen, z.B. in einem ListView oder Log
                accounts?.let {
                    for (account in it) {
                        Log.d("MainActivity", "Account: ${account.kontoNr}, ${account.blz}, ${account.bic}, ${account.iban}, ${account.bemerkung}, ${account.kontotyp}")
                    }
                } ?: run {
                    Log.d("MainActivity", "Keine Konten in der Datenbank gefunden")
                }
            } catch (e: Exception) {
                Log.e("MainActivity", "Fehler beim Laden der Konten", e)
            }
        }
    }
}
