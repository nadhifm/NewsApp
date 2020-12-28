package com.nadhif.core.data.source

import com.nadhif.core.data.source.local.LocalDataSource
import com.nadhif.core.data.source.remote.RemoteDataSource
import com.nadhif.core.data.source.remote.network.ApiResponse
import com.nadhif.core.data.source.remote.response.ArticleResponse
import com.nadhif.core.domain.model.Article
import com.nadhif.core.domain.repository.IArticleRepository
import com.nadhif.core.utils.AppExecutors
import com.nadhif.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ArticleRepository (
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IArticleRepository {

    override fun getAllArticle(): Flow<Resource<List<Article>>> =
        object : NetworkBoundResource<List<Article>, List<ArticleResponse>>() {
            override fun loadFromDB(): Flow<List<Article>> {
                return localDataSource.getAllArticles().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Article>?): Boolean = data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<ArticleResponse>>> =
                remoteDataSource.getAllArticles()

            override suspend fun saveCallResult(data: List<ArticleResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTourism(tourismList)
            }
        }.asFlow()

    override fun getFavoriteArticle(): Flow<List<Article>> {
        return localDataSource.getFavoriteTourism().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteArticle(article: Article, state: Boolean) {
        val articleEntity = DataMapper.mapDomainToEntity(article)
        appExecutors.diskIO().execute { localDataSource.setFavoriteArticle(articleEntity, state) }
    }
}