package com.swati.recyclerviewrestorationpolicydemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.swati.diffutilrecyclerviewdemo.model.NewsDataModel

data class DataModel(
    @Expose
    @SerializedName("articles")
    val articles: ArrayList<NewsDataModel>
)