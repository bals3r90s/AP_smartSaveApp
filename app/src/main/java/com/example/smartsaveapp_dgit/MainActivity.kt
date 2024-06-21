package com.example.smartsaveapp_dgit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.smartsaveapp_dgit.database.AppDatabase
import com.example.smartsaveapp_dgit.ui.theme.SmartSaveApp_dgitTheme
import androidx.appcompat.app.AppCompatActivity
import com.example.smartsaveapp_dgit.database.*
import java.util.Date
import kotlinx.coroutines.launch
import kotlinx.coroutines.GlobalScope

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_item_cash)

        // Erstellen einer Datenbankinstanz
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app-database"
        ).build()

        // Datenbankoperationen
        val accountDao = db.accountDao()
        val savingAccountDao = db.savingAccountDao()
        val transactionDao = db.transactionDao()
        val expensesDao = db.expensesDao()
        val incomesDao = db.incomesDao()
        val accountHolderDao = db.accountHolderDao()

        // GlobalScope führt Befehle asynchron aus, für gleichzeitige Bearbeitung
        GlobalScope.launch {
            // TEST
            val accountHolder = AccountHolder(name = "John Doe", email = "john.doe@example.com")
            accountHolderDao.insert(accountHolder)

            // TEST
            val account = Account(name = "Main Account", balance = 1000.0, accountIban = "DE123456789", accountHolderId = 1)
            accountDao.insert(account)

            // TEST
            val savingAccount = SavingAccount(
                name = "Savings Account",
                balance = 5000.0,
                interestRate = 1.5,
                accountHolderId = 1,
                createdDate = Date()
            )
            savingAccountDao.insert(savingAccount)

            // TEST
            val accounts = accountDao.getAllAccounts()
            for (acc in accounts) {
                println("Account: ${acc.name}, Balance: ${acc.balance}")
            }
        }
    }
}