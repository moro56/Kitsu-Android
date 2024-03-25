package com.app.core.data.models

data class AnimeData(
    val animeList: List<Anime>,
    val prevOffset: Int,
    val nextOffset: Int,
    val lastOffset: Int
)
