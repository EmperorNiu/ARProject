package com.example.arproject.position

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PositionViewModel:ViewModel() {
    private val _latitude: MutableLiveData<Double>
            by lazy { MutableLiveData<Double>().also { it.value = 1.00 }}
    val latitude: LiveData<Double>
        get() = _latitude
    private val _longitiude: MutableLiveData<Double>
            by lazy { MutableLiveData<Double>().also { it.value = 1.02 }}
    val longitiude: LiveData<Double>
        get() = _longitiude
}