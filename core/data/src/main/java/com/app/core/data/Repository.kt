package com.app.core.data

import com.app.core.data.models.AnimeData
import kotlinx.coroutines.CoroutineDispatcher

interface Repository {

    val coroutineDispatcher: CoroutineDispatcher

    /**
     * Retrieve list of anime to display and info about next page to load
     *
     * @param limit number of items to load
     * @param offset offset of the first item to load
     */
    suspend fun getAnimeList(limit: Int, offset: Int): Result<AnimeData>
}