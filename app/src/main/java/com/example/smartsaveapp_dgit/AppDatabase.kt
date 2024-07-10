package com.example.smartsaveapp_dgit

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Account::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun accountDao(): AccountDao
}
