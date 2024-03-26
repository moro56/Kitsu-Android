package com.app.core.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.app.core.data.exts.toModel
import com.app.core.data.models.Anime
import com.app.core.data.paging.AnimeMediator
import com.app.core.local.LocalClient
import com.app.core.local.models.LocalAnime
import com.app.core.network.api.RestApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val restApi: RestApi,
    private val localClient: LocalClient
) : Repository {

    override val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun getAnimeList(): Flow<PagingData<Anime>> =
        animePager.flow.map { pagingData -> pagingData.map { it.toModel() } }

    private val animePager: Pager<Int, LocalAnime> by lazy {
        Pager(
            config = PagingConfig(
                pageSize = BuildConfig.PAGING_LIMIT,
                prefetchDistance = BuildConfig.PAGING_PREFETCH_DISTANCE,
                enablePlaceholders = true
            ),
            pagingSourceFactory = {
                localClient.getAnimePagingSource()
            },
            remoteMediator = AnimeMediator(restApi, localClient)
        )
    }
}