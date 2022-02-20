package com.example.invitationlistplanner.repository

import com.example.invitationlistplanner.database.dao.PersonDao
import com.example.invitationlistplanner.database.entity.Person
import kotlinx.coroutines.flow.Flow

class PersonRepository(private val personDao: PersonDao) {
    suspend fun insertPerson(person: Person) {
        personDao.insertPerson(person)
    }

    suspend fun deletePerson(person: Person) {
        personDao.deletePerson(person)
    }

    fun personsForGroupFlow(id: Int): Flow<List<Person>> = personDao.getAllPersonsForGroup(id)

    val personsFlow: Flow<List<Person>>
        get() = personDao.getAllPersons()
}
