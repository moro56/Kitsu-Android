package com.app.feature.anime.ui

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.app.core.base.mvi.BaseViewModel
import com.app.core.data.Repository
import com.app.core.data.models.Anime
import com.app.feature.anime.ui.paging.AnimePagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Anime viewModel
 *
 * @property repository repository
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
            Pager(config = PagingConfig(20, prefetchDistance = 9, enablePlaceholders = true)) {
                AnimePagingSource(repository)
            }.flow.cachedIn(viewModelScope).collect {
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