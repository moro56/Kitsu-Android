package com.app.core.data.exts

import com.app.core.data.models.Anime
import com.app.core.data.models.AnimePoster
import com.app.core.local.models.LocalAnime
import com.app.core.network.models.RemoteAnime
import com.app.core.network.models.RemoteResponseData
import java.util.Date

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
            id = id,
            createdAt = this.createdAt,
            updatedAt = this.updatedAt,
            slug = this.slug,
            synopsis = this.synopsis,
            title = this.titles.title,
            canonicalTitle = this.canonicalTitle,
            averageRating = this.averageRating,
            startDate = this.startDate,
            endDate = this.endDate,
            ratingRank = this.ratingRank,
            popularityRank = this.popularityRank,
            ageRating = this.ageRating,
            ageRatingGuide = this.ageRatingGuide,
            subtype = this.subtype,
            status = this.status,
            episodeCount = this.episodeCount,
            episodeLength = this.episodeLength,
            youtubeVideoId = this.youtubeVideoId,
            showType = this.showType,
            posterImage = this.posterImage.let {
                AnimePoster(
                    tiny = it.tiny,
                    small = it.small,
                    medium = it.medium,
                    large = it.large,
                    original = it.original
                )
            }
        )
    }
}

/**
 * Map remote model list to domain model list
 */
fun List<RemoteResponseData<RemoteAnime>>.toModelListLocal(offset:Int) = this.map { it.toModelLocal(offset) }

/**
 * Map remote model to domain model
 */
fun RemoteResponseData<RemoteAnime>.toModelLocal(offset:Int): LocalAnime {
    val id = this.id
    return with(this.attributes) {
        val posterImage = this.posterImage
        LocalAnime(
            id = id,
            createdAt = this.createdAt.time,
            updatedAt = this.updatedAt.time,
            slug = this.slug,
            synopsis = this.synopsis,
            title = this.titles.title,
            canonicalTitle = this.canonicalTitle,
            averageRating = this.averageRating,
            startDate = this.startDate,
            endDate = this.endDate,
            ratingRank = this.ratingRank,
            popularityRank = this.popularityRank,
            ageRating = this.ageRating,
            ageRatingGuide = this.ageRatingGuide,
            subtype = this.subtype,
            status = this.status,
            episodeCount = this.episodeCount,
            episodeLength = this.episodeLength,
            youtubeVideoId = this.youtubeVideoId,
            showType = this.showType,
            posterImageTiny = posterImage.tiny,
            posterImageSmall = posterImage.small,
            posterImageMedium = posterImage.medium,
            posterImageLarge = posterImage.large,
            posterImageOriginal = posterImage.original,
            offset = offset
        )
    }
}

/**
 * Map remote model to domain model
 */
fun LocalAnime.toModel(): Anime = Anime(
    id = this.id,
    createdAt = Date(this.createdAt),
    updatedAt = Date(this.updatedAt),
    slug = this.slug,
    synopsis = this.synopsis,
    title = this.title,
    canonicalTitle = this.canonicalTitle,
    averageRating = this.averageRating,
    startDate = this.startDate,
    endDate = this.endDate,
    ratingRank = this.ratingRank,
    popularityRank = this.popularityRank,
    ageRating = this.ageRating,
    ageRatingGuide = this.ageRatingGuide,
    subtype = this.subtype,
    status = this.status,
    episodeCount = this.episodeCount,
    episodeLength = this.episodeLength,
    youtubeVideoId = this.youtubeVideoId,
    showType = this.showType,
    posterImage = AnimePoster(
        tiny = posterImageTiny,
        small = posterImageSmall,
        medium = posterImageMedium,
        large = posterImageLarge,
        original = posterImageOriginal
    )
)
