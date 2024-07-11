package com.example.smartsaveapp_dgit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AccountDao {
    @Query("SELECT * FROM account")
    fun getAllAccounts(): List<Account>

    @Insert
    fun insert(account: Account)
}
