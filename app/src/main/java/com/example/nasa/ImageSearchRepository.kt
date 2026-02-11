package com.example.nasa

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageSearchRepository {
    private val apiService = RetrofitInstanceImages.api.create(ImageSearchApiService::class.java)

    fun searchImages(query: String): LiveData<List<ImageSearchResult>> {
        val data = MutableLiveData<List<ImageSearchResult>>()

        apiService.searchImages(query).enqueue(object : Callback<ImageSearchResponse> {
            override fun onResponse(call: Call<ImageSearchResponse>, response: Response<ImageSearchResponse>) {
                if (response.isSuccessful) {
                    val results = response.body()?.collection?.items?.map {
                        ImageSearchResult(
                            title = it.data.firstOrNull()?.title ?: "No title",
                            imageUrl = it.links.firstOrNull()?.href ?: "",
                            description = it.data.firstOrNull()?.description ?: "No description"
                        )
                    }
                    data.value = results ?: listOf()
                }
            }

            override fun onFailure(call: Call<ImageSearchResponse>, t: Throwable) {
                // Handle error
            }
        })
        return data
    }
}
