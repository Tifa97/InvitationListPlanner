package com.example.invitationlistplanner.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "person_table",
    foreignKeys = [
        ForeignKey(
            entity = Group::class,
            parentColumns = ["id"],
            childColumns = ["person_group_id"],
            onDelete = CASCADE
        )
    ]
)
data class Person(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "person_name")
    val name: String?,

    @ColumnInfo(name = "person_is_adult")
    val isAdult: Boolean?,

    @ColumnInfo(name = "person_group_id")
    val groupId: Int?
)
