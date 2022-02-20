package com.example.invitationlistplanner.ui.mainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.invitationlistplanner.navigation.Routes
import com.example.invitationlistplanner.util.UiEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class MainScreenViewModel : ViewModel() {
    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent: SharedFlow<UiEvent> = _uiEvent

    fun onEvent(event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.OnGuestGroupButtonClick -> sendUiEvent(UiEvent.Navigate(Routes.GROUP_LIST_SCREEN))
            is MainScreenEvent.OnAllGuestsButtonClick -> sendUiEvent(UiEvent.Navigate(Routes.ALL_PERSONS_SCREEN))
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.emit(event)
        }
    }
}
