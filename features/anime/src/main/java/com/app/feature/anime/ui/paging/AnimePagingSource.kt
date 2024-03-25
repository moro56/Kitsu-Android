package com.app.feature.anime.ui.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.app.core.data.Repository
import com.app.core.data.models.Anime

/**
 * Anime [PagingSource]
 *
 * @property repository repository
 */
class AnimePagingSource(private val repository: Repository) : PagingSource<PagingKey, Anime>() {

    override fun getRefreshKey(state: PagingState<PagingKey, Anime>): PagingKey? =
        state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            val prev = anchorPage?.prevKey?.let {
                it.copy(nextOffset = (it.nextOffset + it.limit).coerceAtMost(it.lastOffset))
            }
            val next = anchorPage?.nextKey?.let {
                it.copy(nextOffset = (it.prevOffset - it.limit).coerceAtLeast(0))
            }
            prev ?: next
        }

    override suspend fun load(params: LoadParams<PagingKey>): LoadResult<PagingKey, Anime> {
        val nextPage = params.key ?: PagingKey()
        val result = repository.getAnimeList(nextPage.limit, nextPage.nextOffset)
        return when {
            result.isSuccess -> {
                val data = result.getOrThrow()
                LoadResult.Page(
                    data = data.animeList,
                    prevKey = null,
                    nextKey = nextPage.copy(
                        prevOffset = data.prevOffset,
                        nextOffset = data.nextOffset,
                        lastOffset = data.lastOffset
                    )
                )
            }

            else -> {
                LoadResult.Error(result.exceptionOrNull()!!)
            }
        }
    }
}