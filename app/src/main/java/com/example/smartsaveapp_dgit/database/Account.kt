package com.example.smartsaveapp_dgit.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts")
data class Account(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "account_name") val name: String,
    @ColumnInfo(name = "balance") val balance: Double,
    @ColumnInfo(name = "account_iban") val accountIban: String,
    @ColumnInfo(name = "account_holder_id") val accountHolderId: Int
)