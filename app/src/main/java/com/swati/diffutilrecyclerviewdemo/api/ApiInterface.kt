package com.swati.recyclerviewrestorationpolicydemo.api

import com.swati.recyclerviewrestorationpolicydemo.model.DataModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("top-headlines?country=in&category=business&apiKey=5406e7c04383410ba9ae4201862a5759")
    fun getTopHeadlines(): Call<DataModel>

    @GET("top-headlines?country=us&category=business&apiKey=5406e7c04383410ba9ae4201862a5759")
    fun getUSTopHeadlines(): Call<DataModel>
}