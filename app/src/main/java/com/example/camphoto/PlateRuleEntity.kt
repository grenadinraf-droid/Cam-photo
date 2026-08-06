package com.example.camphoto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plate_rules")
data class PlateRuleEntity(
    @PrimaryKey val plateNumber: String,
    val listType: String,
    val note: String = ""
)
