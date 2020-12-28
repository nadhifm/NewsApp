package com.nadhif.core.data.source.remote.response

data class ArticleResponse(
    val author: String? = "",
    val content: String? = "",
    val description: String? = "",
    val publishedAt: String? = "",
    val title: String? = "",
    val url: String? = "",
    val urlToImage: String? = "",
    val source: Source
)