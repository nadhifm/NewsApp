package com.nadhif.core.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class ListArticleResponse(
    @field:SerializedName("articles")
    val articles: List<ArticleResponse>,
    @field:SerializedName("status")
    val status: String,
    @field:SerializedName("totalResults")
    val totalResults: Int
)