package com.example.invitationlistplanner.repository

import com.example.invitationlistplanner.database.dao.GuestDao
import com.example.invitationlistplanner.database.entity.Guest
import kotlinx.coroutines.flow.Flow

class GuestRepository(private val guestDao: GuestDao) {
    suspend fun insertGuest(person: Guest) {
        guestDao.insertGuest(person)
    }

    suspend fun deleteGuest(person: Guest) {
        guestDao.deleteGuest(person)
    }

    fun guestsForGroupFlow(id: Int): Flow<List<Guest>> = guestDao.getAllGuestsForGroup(id)

    val guestsFlow: Flow<List<Guest>>
        get() = guestDao.getAllGuests()
}
