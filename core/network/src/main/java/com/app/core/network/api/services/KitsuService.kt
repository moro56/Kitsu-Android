package com.app.core.network.api.services

import com.app.core.network.models.RemoteAnime
import com.app.core.network.models.RemoteListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface KitsuService {

    @GET("anime")
    suspend fun getAnimeList(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int
    ): Response<RemoteListResponse<RemoteAnime>>
}