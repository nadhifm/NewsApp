package com.nadhif.core.domain.repository

import com.nadhif.core.data.source.Resource
import com.nadhif.core.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface IArticleRepository {
    fun getAllArticle(): Flow<Resource<List<Article>>>
    fun getFavoriteArticle(): Flow<List<Article>>
    fun setFavoriteArticle(article: Article, state: Boolean)
}