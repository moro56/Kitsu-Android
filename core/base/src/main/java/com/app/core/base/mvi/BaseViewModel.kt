package com.app.core.base.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<Event : UIEvent, State : UIState, Effect : UIEffect> : ViewModel() {
    private val initialState: State by lazy { createInitialState() }

    /**
     * Initialize the viewModel state
     */
    abstract fun createInitialState(): State

    // State flow
    private val uiStateFlow: MutableStateFlow<State> = MutableStateFlow(initialState)
    val uiState = uiStateFlow.asStateFlow()

    // Event flow
    private val uiEventFlow: MutableSharedFlow<Event> = MutableSharedFlow()
    val uiEvent = uiEventFlow.asSharedFlow()

    // Effect flow
    private val uiEffectFlow: MutableSharedFlow<Effect> = MutableSharedFlow()
    val uiEffect = uiEffectFlow.asSharedFlow()

    init {
        subscribeEvents()
    }

    /**
     * Listen to events
     */
    private fun subscribeEvents() {
        viewModelScope.launch {
            uiEvent.collect {
                handleEvent(it)
            }
        }
    }

    /**
     * Handle events
     *
     * @param event the event
     */
    abstract fun handleEvent(event: Event)

    /**
     * Send an event
     *
     * @param event the event
     */
    fun sendEvent(event: Event) {
        viewModelScope.launch {
            uiEventFlow.emit(event)
        }
    }

    /**
     * Update the state
     *
     * @param reduce state reducer
     */
    fun setState(reduce: State.() -> State) {
        uiStateFlow.value = uiState.value.reduce()
    }

    /**
     * Trigger an effect
     *
     * @param builder effect builder
     */
    protected fun setEffect(builder: () -> Effect) {
        val effectValue = builder()
        viewModelScope.launch {
            uiEffectFlow.emit(effectValue)
        }
    }
}
