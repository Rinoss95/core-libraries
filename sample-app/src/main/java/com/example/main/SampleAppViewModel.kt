package com.example.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SampleAppViewModel @Inject constructor() : ViewModel() {
    var isDarkMode by mutableStateOf(false)

    init {
        println("SampleAppViewModel -> isDarkMode = $isDarkMode")
    }

    override fun onCleared() {
        super.onCleared()
    }
}