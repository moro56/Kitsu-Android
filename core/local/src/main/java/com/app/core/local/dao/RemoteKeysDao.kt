package com.app.core.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.core.local.models.LocalRemoteKeys

@Dao
interface RemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<LocalRemoteKeys>)

    @Query("Select * From remote_key Where anime_id = :id")
    suspend fun getRemoteKeyByAnimeID(id: String): LocalRemoteKeys?

    @Query("Delete From remote_key")
    suspend fun clearRemoteKeys()

    @Query("Select created_at From remote_key Order By created_at Desc Limit 1")
    suspend fun getLastCreationTime(): Long?
}
