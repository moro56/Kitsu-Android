package com.app.core.data.models

import java.util.Date

data class Anime(
    val id: String,
    val createdAt: Date,
    val updatedAt: Date,
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
    val posterImage: AnimePoster
)

val animeMockData = Anime(
    id = "1",
    createdAt = Date(),
    updatedAt = Date(),
    slug = "sample-anime",
    synopsis = "This is a sample anime synopsis.",
    title = "Cowboy Bebop",
    canonicalTitle = "Sample Anime",
    averageRating = "8.5",
    startDate = "2023-01-01",
    endDate = "2023-06-30",
    popularityRank = 1234,
    ratingRank = 5678,
    ageRating = "PG-13",
    ageRatingGuide = "Teens 13 or older",
    subtype = "TV",
    status = "Finished",
    episodeCount = 12,
    episodeLength = 24,
    youtubeVideoId = "sampleYoutubeId",
    showType = "TV",
    posterImage = animePosterMockData
)
