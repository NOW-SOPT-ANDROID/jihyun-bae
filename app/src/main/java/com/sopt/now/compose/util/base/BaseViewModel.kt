package com.sopt.now.compose.util.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<State : UiState, SideEffect : UiSideEffect, Event : UiEvent>() :
    ViewModel() {
    private val initialState: State by lazy { createInitialState() }
    abstract fun createInitialState(): State

    private val _uiState = MutableStateFlow<State>(initialState)
    val uiState: StateFlow<State>
        get() = _uiState.asStateFlow()
    val currentState: State
        get() = uiState.value

    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()
    val event: SharedFlow<Event>
        get() = _event.asSharedFlow()

    private val _sideEffect: Channel<SideEffect> = Channel()
    val sideEffect: Flow<SideEffect>
        get() = _sideEffect.receiveAsFlow()

    open fun setEvent(event: Event) {
        dispatchEvent(event)
    }

    fun dispatchEvent(event: Event) = viewModelScope.launch {
        handleEvent(event)
    }

    protected abstract suspend fun handleEvent(event: Event)

    protected fun setState(reduce: State.() -> State) {
        _uiState.value = currentState.reduce()
    }

    protected fun setSideEffect(builder: () -> SideEffect) {
        viewModelScope.launch { _sideEffect.send(builder()) }
    }
}