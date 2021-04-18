package com.swati.diffutilrecyclerviewdemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NewsDataModel(
    @Expose
    @SerializedName("title")
    var title: String,
    @Expose
    @SerializedName("publishedAt")
    var publishedAt: String,
)