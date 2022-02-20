package com.example.invitationlistplanner.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.invitationlistplanner.database.dao.GuestDao
import com.example.invitationlistplanner.database.dao.GuestGroupDao
import com.example.invitationlistplanner.database.entity.Guest
import com.example.invitationlistplanner.database.entity.GuestGroup

@Database(
    entities = [GuestGroup::class, Guest::class],
    version = 3,
    exportSchema = false
)
abstract class InvitationListRoom : RoomDatabase() {
    abstract val guestGroupDao: GuestGroupDao
    abstract val guestDao: GuestDao

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
