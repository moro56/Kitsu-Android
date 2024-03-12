package com.app.core.data.models

import java.util.Date

data class Anime(
    val createdAt: Date,
    val updatedAt: Date,
    val slug: String,
    val synopsis: String,
    val canonicalTitle: String,
    val averageRating: String,
    val startDate: String,
    val endDate: String,
    val popularityRank: Int,
    val ratingRank: Int,
    val ageRating: String,
    val ageRatingGuide: String,
    val subtype: String,
    val status: String,
    val episodeCount: Int,
    val episodeLength: Int,
    val youtubeVideoId: String,
    val showType: String
)
