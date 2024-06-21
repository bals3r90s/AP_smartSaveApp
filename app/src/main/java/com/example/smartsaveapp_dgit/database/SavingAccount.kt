package com.example.smartsaveapp_dgit.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "saving_accounts")
data class SavingAccount(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "saving_account_name") val name: String,
    @ColumnInfo(name = "balance") val balance: Double,
    @ColumnInfo(name = "interest_rate") val interestRate: Double,
    @ColumnInfo(name = "account_holder_id") val accountHolderId: Int,
    @ColumnInfo(name = "created_date") val createdDate: Date
)