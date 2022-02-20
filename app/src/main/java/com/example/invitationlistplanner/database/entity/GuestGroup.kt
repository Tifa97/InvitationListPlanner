package com.example.invitationlistplanner.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "group_table")
data class GuestGroup(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "group_name")
    val groupName: String?,

    @ColumnInfo(name = "group_is_must_have")
    val isMustHave: Boolean?,

    @ColumnInfo(name = "group_is_family")
    val isFamily: Boolean?
)
