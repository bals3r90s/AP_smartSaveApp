package com.example.smartsaveapp_dgit.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SavingAccountDao {
    @Insert
    suspend fun insert(savingAccount: SavingAccount)

    @Update
    suspend fun update(savingAccount: SavingAccount)

    @Query("SELECT * FROM saving_accounts")
    suspend fun getAllSavingAccounts(): List<SavingAccount>

    @Query("SELECT * FROM saving_accounts WHERE id = :savingsAccountId")
    suspend fun getSavingAccountById(savingsAccountId: Int): SavingAccount?

    @Query("DELETE FROM saving_accounts WHERE id = :savingAccountId")
    suspend fun deleteSavingAccountById(savingAccountId: Int)
}
