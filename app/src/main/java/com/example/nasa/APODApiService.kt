package com.example.nasa

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APODApiService {
    @GET("https://api.nasa.gov/planetary/apod")
    fun getAPOD(@Query("api_key") apiKey: String): Call<APODResponse>
}
