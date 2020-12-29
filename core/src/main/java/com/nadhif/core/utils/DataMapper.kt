package com.nadhif.core.utils

import com.nadhif.core.data.source.local.entity.ArticleEntity
import com.nadhif.core.data.source.remote.response.ArticleResponse
import com.nadhif.core.domain.model.Article

object DataMapper {
    fun mapResponsesToEntities(input: List<ArticleResponse>): List<ArticleEntity> {
        val tourismList = ArrayList<ArticleEntity>()
        input.map {
            val tourism = ArticleEntity(
                description = it.description,
                author = it.author,
                content = it.content,
                publishedAt = it.publishedAt,
                title = it.title,
                url = it.url,
                urlToImage = it.urlToImage,
                source = it.source,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapEntitiesToDomain(input: List<ArticleEntity>): List<Article> =
        input.map {
            Article(
                description = it.description,
                author = it.author,
                content = it.content,
                publishedAt = it.publishedAt,
                title = it.title,
                url = it.url,
                urlToImage = it.urlToImage,
                source = it.source,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Article) = ArticleEntity(
        description = input.description,
        author = input.author,
        content = input.content,
        publishedAt = input.publishedAt,
        title = input.title,
        url = input.url,
        urlToImage = input.urlToImage,
        source = input.source,
        isFavorite = input.isFavorite
    )
}