package com.example.smartsaveapp_dgit.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ExpensesDao {
    @Insert
    suspend fun insert(expense: Expenses)

    @Update
    suspend fun update(expense: Expenses)

    @Query("SELECT * FROM expenses")
    suspend fun getAllExpenses(): List<Expenses>

    @Query("SELECT * FROM expenses WHERE id = :expenseId")
    suspend fun getExpenseById(expenseId: Int): Expenses?

    @Query("DELETE FROM expenses WHERE id = :expenseId")
    suspend fun deleteExpenseById(expenseId: Int)
}
