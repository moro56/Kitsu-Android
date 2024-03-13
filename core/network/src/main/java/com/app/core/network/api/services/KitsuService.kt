package com.app.core.network.api.services

import com.app.core.network.models.RemoteAnime
import com.app.core.network.models.RemoteListResponse
import retrofit2.Response
import retrofit2.http.GET

interface KitsuService {

    @GET("anime")
    suspend fun getAnimeList(): Response<RemoteListResponse<RemoteAnime>>
}