package com.example.nasa

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MarsRoverApiService {
    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    fun getMarsPhotos(
        @Query("earth_date") date: String,
        @Query("api_key") apiKey: String
    ): Call<MarsRoverResponse>
}
