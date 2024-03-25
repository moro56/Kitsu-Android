package com.app.core.data

import com.app.core.data.exts.toModelList
import com.app.core.data.models.AnimeData
import com.app.core.network.api.RestApi
import com.app.core.network.models.ApiResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val restApi: RestApi) : Repository {

    override val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun getAnimeList(limit: Int, offset: Int): Result<AnimeData> =
        withContext(coroutineDispatcher) {
            when (val response = restApi.getAnimeList(limit, offset)) {
                is ApiResponse.Error -> {
                    // TODO
                    Result.failure(Exception())
                }

                is ApiResponse.Exception -> {
                    // TODO
                    Result.failure(response.throwable)
                }

                is ApiResponse.Success -> {
                    Result.success(
                        AnimeData(
                            animeList = response.result.data.toModelList(),
                            prevOffset = response.result.links.prevOffset,
                            nextOffset = response.result.links.nextOffset,
                            lastOffset = response.result.links.lastOffset
                        )
                    )
                }
            }
        }
}