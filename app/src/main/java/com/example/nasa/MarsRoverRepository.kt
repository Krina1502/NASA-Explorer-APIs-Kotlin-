package com.example.nasa

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarsRoverRepository {
    private val apiService = RetrofitInstance.api.create(MarsRoverApiService::class.java)

    fun getPhotos(date: String): LiveData<List<MarsRoverPhoto>> {
        val data = MutableLiveData<List<MarsRoverPhoto>>()
        apiService.getMarsPhotos(date, "RIpT6sAy1n8wws2HQNUds9PUxRaeUFQzKYmPnf5l").enqueue(object : Callback<MarsRoverResponse> {
            override fun onResponse(call: Call<MarsRoverResponse>, response: Response<MarsRoverResponse>) {
                if (response.isSuccessful) {
                    data.value = response.body()?.photos
                }
            }

            override fun onFailure(call: Call<MarsRoverResponse>, t: Throwable) {
                // Handle error
            }
        })
        return data
    }
}
