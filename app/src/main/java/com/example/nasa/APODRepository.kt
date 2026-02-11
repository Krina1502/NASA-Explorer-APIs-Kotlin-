package com.example.nasa

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class APODRepository {
    private val apiService = RetrofitInstance.api.create(APODApiService::class.java)

    fun getAPOD(): LiveData<APODResponse> {
        val data = MutableLiveData<APODResponse>()
        apiService.getAPOD("RIpT6sAy1n8wws2HQNUds9PUxRaeUFQzKYmPnf5l").enqueue(object : Callback<APODResponse> {
            override fun onResponse(call: Call<APODResponse>, response: Response<APODResponse>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<APODResponse>, t: Throwable) {
                // Handle error
            }
        })
        return data
    }
}
