package com.example.nasa

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class ImageSearchViewModel : ViewModel() {
    private val repository = ImageSearchRepository()
    lateinit var results: LiveData<List<ImageSearchResult>>

    fun search(query: String) {
        results = repository.searchImages(query)
    }
}
