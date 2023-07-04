package com.example.gamespy.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "place_table")
data class Place(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String
)
