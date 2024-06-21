package com.example.smartsaveapp_dgit.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface AccountHolderDao {
    @Insert
    suspend fun insert(accountHolder: AccountHolder)

    @Update
    suspend fun update(accountHolder: AccountHolder)

    @Query("SELECT * FROM account_holders")
    suspend fun getAllAccountHolders(): List<AccountHolder>

    @Query("SELECT * FROM account_holders WHERE id = :accountHolderId")
    suspend fun getAccountHolderById(accountHolderId: Int): AccountHolder?

    @Query("DELETE FROM account_holders WHERE id = :accountHolderId")
    suspend fun deleteAccountHolderById(accountHolderId: Int)
}
