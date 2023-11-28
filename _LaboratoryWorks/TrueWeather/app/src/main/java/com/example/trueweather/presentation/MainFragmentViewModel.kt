package com.example.trueweather.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trueweather.data.ThroneRepository
import kotlinx.coroutines.coroutineScope

class MainFragmentViewModel(private val repository: ThroneRepository): ViewModel() {
    val id: MutableLiveData<List<Int>> = MutableLiveData(emptyList())
}