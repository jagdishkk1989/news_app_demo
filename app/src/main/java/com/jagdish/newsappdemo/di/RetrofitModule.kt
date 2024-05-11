package com.jagdish.newsappdemo.di


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jagdish.newsappdemo.config.AppConstants.Companion.BASE_URL
import com.jagdish.newsappdemo.data.data_sources.remote.NewsService
import com.jagdish.newsappdemo.data.model.data_mapper.ArticleDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideArticleMapper(): ArticleDtoMapper {
        return ArticleDtoMapper()
    }

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideNewsService(retrofit: Retrofit.Builder): NewsService {
        return retrofit.build().create(NewsService::class.java)
    }
}