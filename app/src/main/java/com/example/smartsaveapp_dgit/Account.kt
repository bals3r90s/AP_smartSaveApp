package com.example.smartsaveapp_dgit

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "account_table")
data class Account(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val kontoNr: String,
    val blz: String,
    val bic: String,
    val iban: String,
    val bemerkung: String,
    val kontotyp: String
)
