package com.example.invitationlistplanner.database.dao

import androidx.room.*
import com.example.invitationlistplanner.database.entity.Guest
import kotlinx.coroutines.flow.Flow

@Dao
interface GuestDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGuest(guest: Guest)

    @Delete
    fun deleteGuest(guest: Guest)

    @Query("SELECT * FROM guest_table")
    fun getAllGuests(): Flow<List<Guest>>

    @Query("SELECT * FROM guest_table WHERE guest_group_id = :groupId")
    fun getAllGuestsForGroup(groupId: Int): Flow<List<Guest>>
}
