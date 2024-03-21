package com.app.core.network.models

import java.util.Date

data class RemoteAnime(
    val createdAt: Date,
    val updatedAt: Date,
    val slug: String,
    val synopsis: String,
    val titles: RemoteAnimeTitle,
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
    val showType: String,
    val posterImage: RemoteAnimePoster
)