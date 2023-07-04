package com.example.gamespy.data.entity.relation

import androidx.room.Entity

@Entity(tableName = "info_place_cross_ref", primaryKeys = ["infoId", "placeId"])
data class InfoPlaceCrossRef(
    val infoId: Int,
    val placeId: String
)
