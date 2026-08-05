package com.example.camphotolpr

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "license_plates")
data class PlateEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val plateNumber: String,
    val timestamp: Long = System.currentTimeMillis(),
    val imagePath: String // Путь к фото на устройстве
)
