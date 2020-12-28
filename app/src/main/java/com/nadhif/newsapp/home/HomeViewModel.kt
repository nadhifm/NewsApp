package com.nadhif.newsapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.nadhif.core.domain.usecase.ArticleUseCase

class HomeViewModel(articleUseCase: ArticleUseCase) : ViewModel() {
    val article = articleUseCase.getAllArticle().asLiveData()
}