package com.example.invitationlistplanner.database.dao

import androidx.room.*
import com.example.invitationlistplanner.database.entity.Person
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPerson(person: Person)

    @Delete
    fun deletePerson(person: Person)

    @Query("SELECT * FROM person_table")
    fun getAllPersons(): Flow<List<Person>>

    @Query("SELECT * FROM person_table WHERE person_group_id = :groupId")
    fun getAllPersonsForGroup(groupId: Int): Flow<List<Person>>
}
