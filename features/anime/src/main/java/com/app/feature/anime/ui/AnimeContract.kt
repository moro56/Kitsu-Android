package com.app.feature.anime.ui

import com.app.core.base.mvi.UIEffect
import com.app.core.base.mvi.UIEvent
import com.app.core.base.mvi.UIState
import com.app.core.data.models.Anime

class AnimeContract {

    sealed class Event : UIEvent

    data class State(val animeList: List<Anime>) : UIState

    sealed class Effect : UIEffect
}
