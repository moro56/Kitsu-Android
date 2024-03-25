package com.app.feature.anime.ui.paging

data class PagingKey(
    val limit: Int = 20,
    val prevOffset: Int = 0,
    val nextOffset: Int = 0,
    val lastOffset: Int = Int.MAX_VALUE
)
