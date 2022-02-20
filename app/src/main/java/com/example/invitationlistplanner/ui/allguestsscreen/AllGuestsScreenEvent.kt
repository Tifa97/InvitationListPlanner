package com.example.invitationlistplanner.ui.allguestsscreen

import com.example.invitationlistplanner.database.entity.Guest

sealed class AllGuestsScreenEvent {
    data class OnDeleteGuestClick(val guest: Guest) : AllGuestsScreenEvent()
    data class OnGuestClick(val guest: Guest) : AllGuestsScreenEvent()
    object OnAddGuestClick : AllGuestsScreenEvent()
    object OnUndoClick : AllGuestsScreenEvent()
}
