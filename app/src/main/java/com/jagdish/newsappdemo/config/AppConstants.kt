package com.jagdish.newsappdemo.config

import com.jagdish.newsappdemo.BuildConfig

class AppConstants {
    companion object {
//      const val NEWS_API_KEY = "XXXX"
        const val NEWS_API_KEY = BuildConfig.API_KEY
        const val BASE_URL = "https://newsapi.org/v2/"
    }
}