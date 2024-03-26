package com.app.core.local

import androidx.paging.PagingSource
import androidx.room.withTransaction
import com.app.core.local.dao.AnimeDao
import com.app.core.local.dao.RemoteKeysDao
import com.app.core.local.database.AppDatabase
import com.app.core.local.models.LocalAnime
import com.app.core.local.models.LocalRemoteKeys
import javax.inject.Inject

class LocalClientImpl @Inject constructor(private val appDatabase: AppDatabase) : LocalClient {

    // Anime dao
    private val animeDao: AnimeDao by lazy { appDatabase.animeDao() }

    // RemoteKeys dao
    private val remoteKeysDao: RemoteKeysDao by lazy { appDatabase.remoteKeysDao() }

    override suspend fun updateDataAfterPagingLoad(
        isRefresh: Boolean,
        remoteKeys: List<LocalRemoteKeys>,
        animeList: List<LocalAnime>
    ) {
        appDatabase.withTransaction {
            if (isRefresh) {
                remoteKeysDao.clearRemoteKeys()
                animeDao.clearAnime()
            }

            remoteKeysDao.insertAll(remoteKeys)
            animeDao.insertAll(animeList)
        }
    }

    override suspend fun retrieveRemoteKeyForAnimeId(animeId: String): LocalRemoteKeys? =
        remoteKeysDao.getRemoteKeyByAnimeID(animeId)

    override suspend fun getAnimeLastRemoteKeyCreationTime(): Long? =
        remoteKeysDao.getLastCreationTime()

    override fun getAnimePagingSource(): PagingSource<Int, LocalAnime> =
        animeDao.getAnimePagingSource()
}
