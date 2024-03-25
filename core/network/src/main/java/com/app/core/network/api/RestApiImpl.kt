package com.app.core.network.api

import com.app.core.network.api.services.KitsuService
import com.app.core.network.exts.apiResponseOf
import com.app.core.network.models.ApiResponse
import com.app.core.network.models.RemoteAnime
import com.app.core.network.models.RemoteListResponse
import javax.inject.Inject

class RestApiImpl @Inject constructor(private val kitsuService: KitsuService) : RestApi {

    override suspend fun getAnimeList(
        limit: Int,
        offset: Int
    ): ApiResponse<RemoteListResponse<RemoteAnime>> =
        apiResponseOf { kitsuService.getAnimeList(limit, offset) }
}
