package com.example.camphoto

import androidx.room.*

@Dao
interface PlateRuleDao {
    @Query("SELECT * FROM plate_rules WHERE plateNumber = :plate LIMIT 1")
    suspend fun getRuleForPlate(plate: String): PlateRuleEntity?

    @Query("SELECT * FROM plate_rules")
    suspend fun getAllRules(): List<PlateRuleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateRule(rule: PlateRuleEntity)

    @Delete
    suspend fun deleteRule(rule: PlateRuleEntity)
}
