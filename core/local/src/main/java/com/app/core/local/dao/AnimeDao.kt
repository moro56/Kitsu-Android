package com.app.core.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.core.local.models.LocalAnime

@Dao
interface AnimeDao {

    @Query("SELECT * FROM anime ORDER BY page")
    fun getAnimePagingSource(): PagingSource<Int, LocalAnime>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(news: List<LocalAnime>)
}