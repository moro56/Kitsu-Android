package com.app.core.data.paging

import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.app.core.data.BuildConfig
import com.app.core.data.exts.toModelListLocal
import com.app.core.local.LocalClient
import com.app.core.local.models.LocalAnime
import com.app.core.local.models.LocalRemoteKeys
import com.app.core.network.api.RestApi
import com.app.core.network.models.ApiResponse
import java.util.concurrent.TimeUnit

class AnimeMediator(private val restApi: RestApi, private val localClient: LocalClient) :
    RemoteMediator<Int, LocalAnime>() {

    override suspend fun initialize(): InitializeAction {
        val cacheTimeout = TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS)
        val lastCreationTime = localClient.getAnimeLastRemoteKeyCreationTime() ?: 0

        return if (System.currentTimeMillis() - lastCreationTime < cacheTimeout) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, LocalAnime>
    ): MediatorResult {
        val offset: Int = when (loadType) {
            LoadType.REFRESH -> 0
            LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
            LoadType.APPEND -> getRemoteKeyForLastItem(state)?.nextOffset ?: 0
        }

        return when (val apiResponse = restApi.getAnimeList(BuildConfig.PAGING_LIMIT, offset)) {
            is ApiResponse.Error -> {
                // TODO
                MediatorResult.Error(Exception())
            }

            is ApiResponse.Exception -> {
                // TODO
                MediatorResult.Error(apiResponse.throwable)
            }

            is ApiResponse.Success -> {
                val data = apiResponse.result.data.toModelListLocal(offset)
                val prevOffset = apiResponse.result.links.prevOffset
                val nextOffset = apiResponse.result.links.nextOffset
                val lastOffset = apiResponse.result.links.lastOffset

                val remoteKeys = data.map {
                    LocalRemoteKeys(
                        animeId = it.id,
                        prevOffset = prevOffset,
                        currentOffset = offset,
                        nextOffset = nextOffset,
                        lastOffset = lastOffset
                    )
                }

                localClient.updateDataAfterPagingLoad(
                    isRefresh = loadType == LoadType.REFRESH,
                    remoteKeys = remoteKeys,
                    animeList = data
                )

                MediatorResult.Success(endOfPaginationReached = nextOffset >= lastOffset)
            }
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, LocalAnime>) =
        state.pages.lastOrNull {
            it.data.isNotEmpty()
        }?.data?.lastOrNull()?.let {
            localClient.retrieveRemoteKeyForAnimeId(it.id)
        }
}
