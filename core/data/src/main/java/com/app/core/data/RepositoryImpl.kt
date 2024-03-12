package com.app.core.data

import com.app.core.data.exts.toModelList
import com.app.core.data.models.Anime
import com.app.core.network.api.RestApi
import com.app.core.network.models.ApiResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val restApi: RestApi) : Repository {

    override val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun getAnimeList(): Result<List<Anime>> = withContext(coroutineDispatcher) {
        when (val response = restApi.getAnimeList()) {
            is ApiResponse.Error -> {
                // TODO
                Result.failure(Exception())
            }

            is ApiResponse.Exception -> {
                // TODO
                Result.failure(response.throwable)
            }

            is ApiResponse.Success -> {
                Result.success(response.result.data.toModelList())
            }
        }
    }
}