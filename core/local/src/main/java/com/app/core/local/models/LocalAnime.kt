package com.app.core.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anime")
data class LocalAnime(
    @PrimaryKey val id: String,
    val createdAt: Long,
    val updatedAt: Long,
    val slug: String,
    val synopsis: String,
    val title: String,
    val canonicalTitle: String,
    val averageRating: String,
    val startDate: String,
    val endDate: String?,
    val popularityRank: Int,
    val ratingRank: Int,
    val ageRating: String,
    val ageRatingGuide: String,
    val subtype: String,
    val status: String,
    val episodeCount: Int,
    val episodeLength: Int,
    val youtubeVideoId: String?,
    val showType: String,
    val posterImageTiny: String,
    val posterImageSmall: String,
    val posterImageMedium: String,
    val posterImageLarge: String,
    val posterImageOriginal: String,
    val offset: Int
)
