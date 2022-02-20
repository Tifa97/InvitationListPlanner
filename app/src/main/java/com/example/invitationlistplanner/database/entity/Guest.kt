package com.example.invitationlistplanner.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "guest_table",
    foreignKeys = [
        ForeignKey(
            entity = GuestGroup::class,
            parentColumns = ["id"],
            childColumns = ["guest_group_id"],
            onDelete = CASCADE
        )
    ]
)
data class Guest(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "guest_name")
    val name: String,

    @ColumnInfo(name = "guest_is_adult")
    val isAdult: Boolean?,

    @ColumnInfo(name = "guest_group_id")
    val groupId: Int?
)
