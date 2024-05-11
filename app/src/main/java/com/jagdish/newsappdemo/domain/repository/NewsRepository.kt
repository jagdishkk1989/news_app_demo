package com.jagdish.newsappdemo.domain.repository

import com.jagdish.newsappdemo.domain.model.Article

interface NewsRepository {

    suspend fun getNews(): List<Article>

    suspend fun deleteArticle(article: Article)

    suspend fun saveArticle(article: Article)

    fun getSavedArticles(): List<Article>

}