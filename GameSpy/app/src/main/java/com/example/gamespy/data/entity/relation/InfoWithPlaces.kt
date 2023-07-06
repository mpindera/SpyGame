package com.example.gamespy.data.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.gamespy.data.entity.Info
import com.example.gamespy.data.entity.Place

data class InfoWithPlaces(
    @Embedded val info: Info,
    @Relation(
        parentColumn = "info_id",
        entityColumn = "info_id"
    )
    val places: List<Place>

)
