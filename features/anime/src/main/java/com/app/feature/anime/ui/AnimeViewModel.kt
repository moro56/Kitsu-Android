package com.app.feature.anime.ui

import androidx.lifecycle.viewModelScope
import com.app.core.base.mvi.BaseViewModel
import com.app.core.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(private val repository: Repository) :
    BaseViewModel<AnimeContract.Event, AnimeContract.State, AnimeContract.Effect>() {

    init {
        loadAnimeList()
    }

    override fun createInitialState() = AnimeContract.State(animeList = emptyList())

    override fun handleEvent(event: AnimeContract.Event) {
    }

    private fun loadAnimeList() = viewModelScope.launch {
        val result = repository.getAnimeList()
        println(result)
    }
}