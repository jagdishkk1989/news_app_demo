package com.jagdish.newsappdemo.domain.model

import android.os.Parcelable
import com.jagdish.newsappdemo.domain.SourceEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    var id: Int? = null,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: SourceEntity?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) : Parcelable