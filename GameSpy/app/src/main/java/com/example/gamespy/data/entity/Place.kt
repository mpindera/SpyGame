package com.example.gamespy.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "places_table")
data class Place(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "info_id") val infoId: Int,
    val name: String
)
