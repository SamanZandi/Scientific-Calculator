package com.zandroid.mycalculator.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor() :ViewModel() {

    var calculationText:String="0"
    var resultText:String="0"

fun appendText(text:String){
    if (calculationText == "0" && resultText == "0"){
      calculationText=""
      resultText=""
    }
    calculationText+=text
    resultText+=text
}

}