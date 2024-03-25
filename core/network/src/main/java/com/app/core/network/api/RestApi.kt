package com.app.core.network.api

import com.app.core.network.models.ApiResponse
import com.app.core.network.models.RemoteAnime
import com.app.core.network.models.RemoteListResponse

interface RestApi {

    /**
     * Retrieve list of anime to display
     *
     * @param limit number of items to load
     * @param offset offset of the first item to load
     */
    suspend fun getAnimeList(limit: Int, offset: Int): ApiResponse<RemoteListResponse<RemoteAnime>>
}