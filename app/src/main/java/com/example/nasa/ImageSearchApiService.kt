package com.example.nasa

import okhttp3.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageSearchApiService {
    @GET("search")
    fun searchImages(
        @Query("q") query: String,
        @Query("media_type") mediaType: String = "image"
    ): Call<ImageSearchResponse>
}
