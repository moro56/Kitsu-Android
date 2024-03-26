package com.app.feature.anime.ui

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.app.core.base.mvi.BaseViewModel
import com.app.core.data.Repository
import com.app.core.data.models.Anime
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Anime viewModel
 */
@HiltViewModel
class AnimeViewModel @Inject constructor(private val repository: Repository) :
    BaseViewModel<AnimeContract.Event, AnimeContract.State, AnimeContract.Effect>() {

    // Support flow for maintaining a single state
    private val pagingFlow: MutableStateFlow<PagingData<Anime>> =
        MutableStateFlow(PagingData.empty())

    init {
        // Initialize paging library
        viewModelScope.launch {
            repository.getAnimeList().cachedIn(viewModelScope).collect {
                // Use both so that we pass to the state the paging state too
                pagingFlow.value = it
                setState { copy(animeData = pagingFlow) }
            }
        }
    }

    override fun createInitialState() =
        AnimeContract.State(animeData = MutableStateFlow(PagingData.empty()))

    override fun handleEvent(event: AnimeContract.Event) {
    }
}
