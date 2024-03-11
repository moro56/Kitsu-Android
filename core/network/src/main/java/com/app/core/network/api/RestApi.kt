package com.app.core.network.api

import com.app.core.network.models.ApiResponse
import com.app.core.network.models.RemoteAnime
import com.app.core.network.models.RemoteListResponse

interface RestApi {

    suspend fun getAnimeList(): ApiResponse<RemoteListResponse<RemoteAnime>>
}