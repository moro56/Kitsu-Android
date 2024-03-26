package com.app.core.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_key")
data class LocalRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "anime_id")
    val animeId: String,
    val prevOffset: Int?,
    val currentOffset: Int,
    val nextOffset: Int?,
    val lastOffset: Int,
    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis()
)
