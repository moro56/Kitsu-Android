package com.app.core.data

import com.app.core.data.models.Anime
import kotlinx.coroutines.CoroutineDispatcher

interface Repository {

    val coroutineDispatcher: CoroutineDispatcher

    suspend fun getAnimeList(): Result<List<Anime>>
}