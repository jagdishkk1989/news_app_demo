package com.jagdish.newsappdemo.data.data_sources.remote

import com.jagdish.newsappdemo.BuildConfig
import com.jagdish.newsappdemo.config.AppConstants
import com.jagdish.newsappdemo.data.response.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {




    @GET("top-headlines")
    suspend fun getNews(
        @Query("country")
        country: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = AppConstants.NEWS_API_KEY
    ): Response<NewsResponse>


}