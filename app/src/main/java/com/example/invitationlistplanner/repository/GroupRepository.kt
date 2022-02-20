package com.example.invitationlistplanner.repository

import com.example.invitationlistplanner.database.dao.GroupDao
import com.example.invitationlistplanner.database.entity.Group
import kotlinx.coroutines.flow.Flow

class GroupRepository(private val groupDao: GroupDao) {
    fun insertGroup(group: Group) {
        groupDao.insertGroup(group)
    }

    fun deleteGroup(group: Group) {
        groupDao.deleteGroup(group)
    }

    val groupFlow: Flow<List<Group>>
        get() = groupDao.getAllGroupsFlow()
}
