package com.jagdish.newsappdemo.di

import com.jagdish.newsappdemo.data.data_sources.local.ArticleDatabase
import com.jagdish.newsappdemo.data.data_sources.remote.NewsService
import com.jagdish.newsappdemo.data.model.data_mapper.ArticleDtoMapper
import com.jagdish.newsappdemo.domain.repositor.NewsRepositoryImpl
import com.jagdish.newsappdemo.domain.repository.NewsRepository


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        newsService: NewsService,
        db: ArticleDatabase,
        mapper: ArticleDtoMapper
    ): NewsRepository {
        return NewsRepositoryImpl(newsService, db, mapper)
    }

}