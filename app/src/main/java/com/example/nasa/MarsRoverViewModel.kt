package com.example.nasa

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MarsRoverViewModel : ViewModel() {
    private val repository = MarsRoverRepository()
    lateinit var photos: LiveData<List<MarsRoverPhoto>>

    fun fetchPhotos(date: String) {
        photos = repository.getPhotos(date)
    }
}
