package com.jagdish.newsappdemo.data.model.data_mapper

import com.jagdish.newsappdemo.data.model.ArticleDto
import com.jagdish.newsappdemo.domain.model.Article
import com.jagdish.newsappdemo.domain.model.util.DomainMapper


class ArticleDtoMapper : DomainMapper<ArticleDto, Article> {

    override fun mapToDomainModel(model: ArticleDto): Article {
        return Article(
            id = model.id,
            author = model.author,
            content = model.content,
            title = model.title,
            description = model.description,
            publishedAt = model.publishedAt,
            source = model.source,
            url = model.url,
            urlToImage = model.urlToImage
        )
    }

    override fun mapFromDomainModel(domainModel: Article): ArticleDto {
        return ArticleDto(
            id = domainModel.id,
            author = domainModel.author,
            content = domainModel.content,
            title = domainModel.title,
            description = domainModel.description,
            publishedAt = domainModel.publishedAt,
            source = domainModel.source,
            url = domainModel.url,
            urlToImage = domainModel.urlToImage
        )
    }

    fun toDomainList(initial: List<ArticleDto>): List<Article> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Article>): List<ArticleDto> {
        return initial.map { mapFromDomainModel(it) }
    }


}