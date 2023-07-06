package com.example.gamespy.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "places_table")
data class Place(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "places_id")
    val placesID: Int = 0,
    val namePlaces: String,
    @ColumnInfo(name = "info_id")
    val infoID: Int
)
