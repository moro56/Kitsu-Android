package com.app.feature.anime.ui

import com.app.core.base.mvi.UIEffect
import com.app.core.base.mvi.UIEvent
import com.app.core.base.mvi.UIState
import com.app.core.data.models.Anime
import com.app.core.data.models.animeMockData

class AnimeContract {

    sealed class Event : UIEvent

    data class State(val animeList: List<Anime>, val loading: Boolean) : UIState

    sealed class Effect : UIEffect
}

val animeStateMock = AnimeContract.State(animeList = listOf(animeMockData), loading = false)