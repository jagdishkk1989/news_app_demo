package com.jagdish.newsappdemo.data.response

import com.google.gson.annotations.SerializedName
import com.jagdish.newsappdemo.data.model.ArticleDto


data class NewsResponse(
    @SerializedName("articles")
    val articles: List<ArticleDto>,
    @SerializedName("status")
    val status: String?,
    @SerializedName("totalResults")
    val totalResults: Int
)