package com.zandroid.mycalculator.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zandroid.mycalculator.utils.TABLE_HISTORY
import kotlinx.coroutines.flow.Flow


@Dao
interface CalcDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCalculation(calcEntity: CalcEntity)

    @Delete
    suspend fun deleteExpression(calcEntity: CalcEntity)

    @Query("DELETE FROM $TABLE_HISTORY")
    fun clearHistory()

    @Query("SELECT * FROM $TABLE_HISTORY ORDER BY id DESC")
   fun getAllHistory(): Flow<MutableList<CalcEntity>>

}