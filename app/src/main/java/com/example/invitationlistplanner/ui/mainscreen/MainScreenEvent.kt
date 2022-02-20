package com.example.invitationlistplanner.ui.mainscreen

sealed class MainScreenEvent {
    object OnGuestGroupButtonClick : MainScreenEvent()
    object OnAllGuestsButtonClick : MainScreenEvent()
}
