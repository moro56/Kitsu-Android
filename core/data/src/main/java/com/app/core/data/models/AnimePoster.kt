package com.app.core.data.models

data class AnimePoster(
    val tiny: String,
    val small: String,
    val medium: String,
    val large: String,
    val original: String
)

val animePosterMockData = AnimePoster(
    tiny = "https://media.kitsu.io/anime/poster_images/1/tiny.jpg?1431697256",
    small = "https://media.kitsu.io/anime/poster_images/1/small.jpg?1431697256",
    medium = "https://media.kitsu.io/anime/poster_images/1/medium.jpg?1431697256",
    large = "https://media.kitsu.io/anime/poster_images/1/large.jpg?1431697256",
    original = "https://media.kitsu.io/anime/poster_images/1/original.jpg?1431697256"
)
