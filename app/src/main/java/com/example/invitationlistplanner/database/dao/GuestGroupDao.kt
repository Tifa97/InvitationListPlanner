package com.example.invitationlistplanner.database.dao

import androidx.room.*
import com.example.invitationlistplanner.database.entity.GuestGroup
import kotlinx.coroutines.flow.Flow

@Dao
interface GuestGroupDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGroup(group: GuestGroup)

    @Delete
    fun deleteGroup(group: GuestGroup)

    @Query("SELECT * FROM group_table")
    fun getAllGroupsFlow(): Flow<List<GuestGroup>>
}
