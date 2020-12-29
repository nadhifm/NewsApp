package com.nadhif.core.data.source.local

import com.nadhif.core.data.source.local.entity.ArticleEntity
import com.nadhif.core.data.source.local.room.ArticleDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val articleDao: ArticleDao) {

    fun getAllArticles(): Flow<List<ArticleEntity>> = articleDao.getAllArticles()

    fun getFavoriteArticle(): Flow<List<ArticleEntity>> = articleDao.getFavoriteArticles()

    suspend fun insertArticle(articleList: List<ArticleEntity>) = articleDao.insertArticles(articleList)

    fun setFavoriteArticle(article: ArticleEntity, newState: Boolean) {
        article.isFavorite = newState
        articleDao.updateFavoriteArticle(article)
    }
}