package com.nadhif.core.data.source.remote.response


data class ListArticleResponse(
    val articles: List<ArticleResponse>,
    val status: String,
    val totalResults: Int
)