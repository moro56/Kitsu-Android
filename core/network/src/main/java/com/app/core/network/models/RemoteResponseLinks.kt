package com.app.core.network.models

data class RemoteResponseLinks(
    val first: String,
    val prev: String?,
    val next: String?,
    val last: String
) {
    val prevOffset: Int
        get() = prev?.substringAfterLast("=")?.toInt() ?: 0
    val nextOffset: Int
        get() = next?.substringAfterLast("=")?.toInt() ?: lastOffset
    val lastOffset: Int
        get() = last.substringAfterLast("=").toInt()
}
