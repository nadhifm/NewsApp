package com.nadhif.core.domain.model

import android.os.Parcelable
import com.nadhif.core.data.source.remote.response.Source
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Article(
        val articleId: Long,
        val author: String? = "",
        val content: String? = "",
        val description: String? = "",
        val publishedAt: String? = "",
        val title: String? = "",
        val url: String? = "",
        val urlToImage: String? = "",
        val source: @RawValue Source,
        val isFavorite: Boolean
): Parcelable