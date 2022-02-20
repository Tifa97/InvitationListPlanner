package com.example.invitationlistplanner.ui.allguestsscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.invitationlistplanner.database.entity.Guest
import com.example.invitationlistplanner.navigation.Routes
import com.example.invitationlistplanner.repository.GuestRepository
import com.example.invitationlistplanner.util.UiEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AllGuestsViewModel(
    private val guestRepository: GuestRepository
) : ViewModel() {
    val guests = guestRepository.guestsFlow

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent: SharedFlow<UiEvent> = _uiEvent

    private var deletedGuest: Guest? = null

    fun addGuest() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                guestRepository.insertGuest(
                    Guest(
                        name = "Pero",
                        isAdult = true,
                        groupId = null
                    )
                )
            }
        }
    }

    fun deleteGuest(guest: Guest) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                guestRepository.deleteGuest(guest)
            }
        }
    }

    fun onEvent(event: AllGuestsScreenEvent) {
        when (event) {
            is AllGuestsScreenEvent.OnDeleteGuestClick -> {
                deletedGuest = event.guest
                deleteGuest(event.guest)
                sendUiEvent(
                    UiEvent.ShowSnackbar(
                        "Guest ${event.guest.name} deleted!",
                        "Undo"
                    )
                )
            }
            is AllGuestsScreenEvent.OnUndoClick -> {
                deletedGuest?.let { guest ->
                    viewModelScope.launch {
                        withContext(Dispatchers.IO){ guestRepository.insertGuest(guest) }
                    }
                }
            }
            is AllGuestsScreenEvent.OnAddGuestClick -> sendUiEvent(UiEvent.Navigate(Routes.ALL_PERSONS_SCREEN))
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.emit(event)
        }
    }
}
