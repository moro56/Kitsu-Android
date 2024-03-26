package com.app.core.local

import androidx.paging.PagingSource
import com.app.core.local.models.LocalAnime
import com.app.core.local.models.LocalRemoteKeys

interface LocalClient {

    /**
     * Update the state of the saved data after the pagination loaded another page
     *
     * @param isRefresh the data are updated by a refresh
     * @param remoteKeys list of locale remote keys entities
     * @param animeList list of local anime entities
     */
    suspend fun updateDataAfterPagingLoad(
        isRefresh: Boolean,
        remoteKeys: List<LocalRemoteKeys>,
        animeList: List<LocalAnime>
    )

    /**
     * Retrieve [LocalRemoteKeys] info for an anime by id
     *
     * @param animeId id of the anime
     */
    suspend fun retrieveRemoteKeyForAnimeId(animeId: String): LocalRemoteKeys?

    /**
     * Retrieve creation time of the last [LocalRemoteKeys] for the anime list
     */
    suspend fun getAnimeLastRemoteKeyCreationTime(): Long?

    /**
     * Get the anime [PagingSource] used in the paging library
     */
    fun getAnimePagingSource(): PagingSource<Int, LocalAnime>
}