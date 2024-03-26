package com.app.core.local.di

import android.content.Context
import androidx.room.Room
import com.app.core.local.dao.AnimeDao
import com.app.core.local.dao.RemoteKeysDao
import com.app.core.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun providesDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "localDb").build()

    @Provides
    fun providesAnimeDao(appDatabase: AppDatabase): AnimeDao = appDatabase.animeDao()

    @Provides
    fun providesRemoteKeysDao(appDatabase: AppDatabase): RemoteKeysDao = appDatabase.remoteKeysDao()
}