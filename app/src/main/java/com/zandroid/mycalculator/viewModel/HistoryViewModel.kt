package com.zandroid.mycalculator.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.zandroid.mycalculator.repository.HistoryRepository
import com.zandroid.mycalculator.room.CalcEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(private val repository: HistoryRepository):ViewModel() {

    fun insertHistory(historyItem:CalcEntity)=viewModelScope.launch {
        repository.insertCalculation(historyItem)
    }

    fun deleteExpression(historyItem:CalcEntity)=viewModelScope.launch {
        repository.deleteExpression(historyItem)
    }

    val loadHistories=repository.getAllHistories().asLiveData()

    fun clearHistory() {
        repository.clearHistory()
    }


}