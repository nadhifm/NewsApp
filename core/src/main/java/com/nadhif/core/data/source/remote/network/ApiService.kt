package com.nadhif.core.data.source.remote.network

import com.nadhif.core.BuildConfig
import com.nadhif.core.data.source.remote.response.ListArticleResponse
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = BuildConfig.APIKEY
interface ApiService {
    @GET("top-headlines")
    suspend fun getListArticle(
        @Query("country")
        countryCode: String = "id",
        @Query("apiKey")
        apiKey: String = API_KEY
    ): ListArticleResponse
}