package com.nadhif.core.data.source.local.room

import androidx.room.*
import com.nadhif.core.data.source.local.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {
    @Query("SELECT * FROM article")
    fun getAllArticles(): Flow<List<ArticleEntity>>

    @Query("SELECT * FROM article where isFavorite = 1")
    fun getFavoriteArticles(): Flow<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(listArticleEntity: List<ArticleEntity>)

    @Update
    fun updateFavoriteArticle(articleEntity: ArticleEntity)

    @Query("DELETE FROM article")
    suspend fun deleteAllArticle()

}