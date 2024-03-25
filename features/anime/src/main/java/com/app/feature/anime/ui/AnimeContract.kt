package com.app.feature.anime.ui

import androidx.paging.PagingData
import com.app.core.base.mvi.UIEffect
import com.app.core.base.mvi.UIEvent
import com.app.core.base.mvi.UIState
import com.app.core.data.models.Anime
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AnimeContract {

    sealed class Event : UIEvent

    /**
     * State
     *
     * @property animeData state containing the [PagingData] state
     */
    data class State(val animeData: StateFlow<PagingData<Anime>>) : UIState

    sealed class Effect : UIEffect
}

val animeStateMock = AnimeContract.State(animeData = MutableStateFlow(PagingData.empty()))