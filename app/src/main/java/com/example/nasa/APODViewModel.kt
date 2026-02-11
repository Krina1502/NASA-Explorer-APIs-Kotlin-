package com.example.nasa

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class APODViewModel : ViewModel() {
    private val repository = APODRepository()
    val apodData: LiveData<APODResponse> = repository.getAPOD()
}
