package com.example.gamespy.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "info_table")
data class Info(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "info_id")
    var infoID: Int = 0,
    @ColumnInfo(name = "nameInfo")
    val nameInfo: String
)