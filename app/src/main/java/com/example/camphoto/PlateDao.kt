package com.example.camphoto

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PlateDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(plate: PlateEntity)

    @Query("SELECT * FROM license_plates ORDER BY timestamp DESC")
    fun getAllPlates(): Flow<List<PlateEntity>>
}
