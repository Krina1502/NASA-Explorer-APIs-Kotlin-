package com.example.nasa

data class APODResponse(
    val date: String,
    val explanation: String,
    val hdurl: String,
    val title: String,
    val url: String
)
