package com.app.core.data.exts

import com.app.core.data.models.Anime
import com.app.core.network.models.RemoteAnime
import com.app.core.network.models.RemoteResponseData

/**
 * Map remote model list to domain model list
 */
fun List<RemoteResponseData<RemoteAnime>>.toModelList() = this.map { it.toModel() }

/**
 * Map remote model to domain model
 */
fun RemoteResponseData<RemoteAnime>.toModel(): Anime {
    val id = this.id
    return with(this.attributes) {
        Anime(
            id,
            this.createdAt,
            this.updatedAt,
            this.slug,
            this.synopsis,
            this.canonicalTitle,
            this.averageRating,
            this.startDate,
            this.endDate,
            this.ratingRank,
            this.popularityRank,
            this.ageRating,
            this.ageRatingGuide,
            this.subtype,
            this.status,
            this.episodeCount,
            this.episodeLength,
            this.youtubeVideoId,
            this.showType
        )
    }
}
