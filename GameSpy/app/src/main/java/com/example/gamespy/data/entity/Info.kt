package com.example.gamespy.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "headline_table")
data class Info(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String
)