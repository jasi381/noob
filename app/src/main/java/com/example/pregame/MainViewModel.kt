package com.example.pregame

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel:ViewModel() {
    private val timerText = MutableStateFlow("Hello")
    val timerState = timerText.asStateFlow()

    fun screenChanged(text : String){
        timerText.value = text
    }

}