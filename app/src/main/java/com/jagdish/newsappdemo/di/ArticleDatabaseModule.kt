package com.jagdish.newsappdemo.di

import android.content.Context
import com.jagdish.newsappdemo.data.data_sources.local.ArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ArticleDatabaseModule {

    @Singleton
    @Provides
    fun provideArticleDatabase(@ApplicationContext context: Context): ArticleDatabase {
        return ArticleDatabase(context)
    }
}