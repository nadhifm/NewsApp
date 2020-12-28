package com.nadhif.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nadhif.core.data.source.remote.response.Source

@Entity(tableName = "article")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "articleId")
    val articleId: Long = 0,

    @ColumnInfo(name = "author")
    val author: String? = "",

    @ColumnInfo(name = "content")
    val content: String? = "",

    @ColumnInfo(name = "description")
    val description: String? = "",

    @ColumnInfo(name = "publishedAt")
    val publishedAt: String? = "",

    @ColumnInfo(name = "title")
    val title: String? = "",

    @ColumnInfo(name = "url")
    val url: String? = "",

    @ColumnInfo(name = "urlToImage")
    val urlToImage: String? = "",

    @ColumnInfo(name = "source")
    val source: Source,

        @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
