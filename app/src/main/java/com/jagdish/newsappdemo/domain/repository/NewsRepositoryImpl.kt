package com.jagdish.newsappdemo.domain.repositor

import com.jagdish.newsappdemo.data.data_sources.local.ArticleDatabase
import com.jagdish.newsappdemo.data.data_sources.remote.NewsService
import com.jagdish.newsappdemo.data.model.data_mapper.ArticleDtoMapper
import com.jagdish.newsappdemo.domain.model.Article
import com.jagdish.newsappdemo.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject
constructor(
    private val newsService: NewsService,
    private val db: ArticleDatabase,
    private val mapper: ArticleDtoMapper,
) : NewsRepository {

    override suspend fun getNews() =
        mapper.toDomainList(newsService.getNews("IN", 1).body()!!.articles)


    override suspend fun saveArticle(article: Article) {
        db.getArticleDao().insertUpdate(mapper.mapFromDomainModel(article))
    }

    override fun getSavedArticles(): List<Article> =
        mapper.toDomainList(db.getArticleDao().getSavedArticles())


    override suspend fun deleteArticle(article: Article) {
        db.getArticleDao().deleteArticle(mapper.mapFromDomainModel(article))
    }

}