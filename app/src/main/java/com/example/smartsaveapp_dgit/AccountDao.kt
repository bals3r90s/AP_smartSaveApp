package com.example.smartsaveapp_dgit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AccountDao {
    @Insert
    suspend fun insert(account: Account)

    @Query("SELECT * FROM account_table WHERE id = :id")
    suspend fun getAccountById(id: Int): Account?

    @Query("SELECT * FROM account_table")
    suspend fun getAllAccounts(): List<Account>?
}
