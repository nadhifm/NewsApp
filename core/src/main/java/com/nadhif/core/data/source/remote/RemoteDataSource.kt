package com.nadhif.core.data.source.remote

import android.util.Log
import com.nadhif.core.data.source.remote.network.ApiResponse
import com.nadhif.core.data.source.remote.network.ApiService
import com.nadhif.core.data.source.remote.response.ArticleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun getAllArticles(): Flow<ApiResponse<List<ArticleResponse>>> {
        //get data from remote api
        return flow {
            try {
                val response = apiService.getListArticle()
                val dataArray = response.articles
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.articles))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}