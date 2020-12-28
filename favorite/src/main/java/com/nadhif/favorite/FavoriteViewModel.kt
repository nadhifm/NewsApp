package com.nadhif.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.nadhif.core.domain.usecase.ArticleUseCase

class FavoriteViewModel(articleUseCase: ArticleUseCase) : ViewModel() {
    val favoriteArticle = articleUseCase.getFavoriteArticle().asLiveData()
}