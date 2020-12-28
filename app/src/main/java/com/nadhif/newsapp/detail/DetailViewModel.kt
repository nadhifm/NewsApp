package com.nadhif.newsapp.detail

import androidx.lifecycle.ViewModel
import com.nadhif.core.domain.model.Article
import com.nadhif.core.domain.usecase.ArticleUseCase

class DetailViewModel(private val articleUseCase: ArticleUseCase): ViewModel() {
    fun setFavoriteArticle(article: Article, newState: Boolean) =
        articleUseCase.setFavoriteArticle(article, newState)
}