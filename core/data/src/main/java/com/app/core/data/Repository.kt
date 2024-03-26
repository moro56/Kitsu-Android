package com.app.core.data

import androidx.paging.PagingData
import com.app.core.data.models.Anime
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

interface Repository {

    val coroutineDispatcher: CoroutineDispatcher

    /**
     * Retrieve [Flow] of the paginated list of anime
     */
    suspend fun getAnimeList(): Flow<PagingData<Anime>>
}
