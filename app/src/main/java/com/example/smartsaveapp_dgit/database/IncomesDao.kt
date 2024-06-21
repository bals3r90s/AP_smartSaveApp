package com.example.smartsaveapp_dgit.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface IncomesDao {
    @Insert
    suspend fun insert(income: Incomes)

    @Update
    suspend fun update(income: Incomes)

    @Query("SELECT * FROM incomes")
    suspend fun getAllIncomes(): List<Incomes>

    @Query("SELECT * FROM incomes WHERE id = :incomeId")
    suspend fun getIncomeById(incomeId: Int): Incomes?

    @Query("DELETE FROM incomes WHERE id = :incomeId")
    suspend fun deleteIncomeById(incomeId: Int)
}
