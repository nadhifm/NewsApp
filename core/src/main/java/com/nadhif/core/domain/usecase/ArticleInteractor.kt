package com.nadhif.core.domain.usecase

import com.nadhif.core.data.source.Resource
import com.nadhif.core.domain.model.Article
import com.nadhif.core.domain.repository.IArticleRepository
import kotlinx.coroutines.flow.Flow

class ArticleInteractor(private val articleRepository: IArticleRepository): ArticleUseCase {
    override fun getAllArticle(): Flow<Resource<List<Article>>> = articleRepository.getAllArticle()

    override fun getFavoriteArticle(): Flow<List<Article>> = articleRepository.getFavoriteArticle()

    override fun setFavoriteArticle(article: Article, state: Boolean) = articleRepository.setFavoriteArticle(article, state)
}