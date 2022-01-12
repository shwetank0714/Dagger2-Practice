package com.example.practiceproject.di

import com.example.practiceproject.models.ListData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServiceInterface {

    @GET("/repositories")
    fun getDataFromAPI(@Query("q")query: String): Call<ListData>
}