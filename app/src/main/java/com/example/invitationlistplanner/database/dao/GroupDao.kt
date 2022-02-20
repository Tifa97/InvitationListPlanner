package com.example.invitationlistplanner.database.dao

import androidx.room.*
import com.example.invitationlistplanner.database.entity.Group
import kotlinx.coroutines.flow.Flow

@Dao
interface GroupDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGroup(group: Group)

    @Delete
    fun deleteGroup(group: Group)

    @Query("SELECT * FROM group_table")
    fun getAllGroupsFlow(): Flow<List<Group>>
}
