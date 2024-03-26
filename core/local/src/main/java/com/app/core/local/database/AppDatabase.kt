package com.app.core.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.core.local.dao.AnimeDao
import com.app.core.local.dao.RemoteKeysDao
import com.app.core.local.models.LocalAnime
import com.app.core.local.models.LocalRemoteKeys

@Database(entities = [LocalAnime::class, LocalRemoteKeys::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun animeDao(): AnimeDao
    abstract fun remoteKeysDao(): RemoteKeysDao
}
