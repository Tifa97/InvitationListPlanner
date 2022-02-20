package com.example.invitationlistplanner.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.invitationlistplanner.database.dao.GroupDao
import com.example.invitationlistplanner.database.dao.PersonDao
import com.example.invitationlistplanner.database.entity.Group
import com.example.invitationlistplanner.database.entity.Person

@Database(
    entities = [Group::class, Person::class],
    version = 1,
    exportSchema = false
)
abstract class InvitationListRoom : RoomDatabase() {
    abstract val groupDao: GroupDao
    abstract val personDao: PersonDao

    companion object {

        @Volatile
        private var INSTANCE: InvitationListRoom? = null

        fun getInstance(context: Context): InvitationListRoom {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        InvitationListRoom::class.java,
                        "brewery_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
