package com.example.invitationlistplanner.repository

import com.example.invitationlistplanner.database.dao.GuestGroupDao
import com.example.invitationlistplanner.database.entity.GuestGroup
import kotlinx.coroutines.flow.Flow

class GuestGroupRepository(private val guestGroupDao: GuestGroupDao) {
    fun insertGroup(group: GuestGroup) {
        guestGroupDao.insertGroup(group)
    }

    fun deleteGroup(group: GuestGroup) {
        guestGroupDao.deleteGroup(group)
    }

    val groupFlow: Flow<List<GuestGroup>>
        get() = guestGroupDao.getAllGroupsFlow()
}
