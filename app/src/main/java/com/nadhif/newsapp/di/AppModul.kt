package com.nadhif.newsapp.di

import com.nadhif.core.domain.usecase.ArticleInteractor
import com.nadhif.core.domain.usecase.ArticleUseCase
import com.nadhif.newsapp.detail.DetailViewModel
import com.nadhif.newsapp.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<ArticleUseCase> { ArticleInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}