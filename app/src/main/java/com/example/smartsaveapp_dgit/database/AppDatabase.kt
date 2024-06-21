package com.example.smartsaveapp_dgit.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        Account::class,
        SavingAccount::class,
        Transaction::class,
        Expenses::class,
        Incomes::class,
        AccountHolder::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun accountDao(): AccountDao
    abstract fun savingAccountDao(): SavingAccountDao
    abstract fun transactionDao(): TransactionDao
    abstract fun expensesDao(): ExpensesDao
    abstract fun incomesDao(): IncomesDao
    abstract fun accountHolderDao(): AccountHolderDao
}
