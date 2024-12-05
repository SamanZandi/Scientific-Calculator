package com.zandroid.mycalculator.repository

import com.zandroid.mycalculator.room.CalcDao
import com.zandroid.mycalculator.room.CalcEntity
import javax.inject.Inject


class HistoryRepository @Inject constructor(private val dao: CalcDao){
    suspend fun insertCalculation(entity: CalcEntity)=dao.insertCalculation(entity)
    suspend fun deleteExpression(entity: CalcEntity)=dao.deleteExpression(entity)
     fun clearHistory()=dao.clearHistory()
     fun getAllHistories()=dao.getAllHistory()
}