package com.example.camphoto

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [PlateEntity::class, PlateRuleEntity::class], // Добавили сущность правил
    version = 2, 
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    
    abstract fun plateDao(): PlateDao
    abstract fun plateRuleDao(): PlateRuleDao // Добавили DAO для черного/белого списков

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "license_plates_db"
                )
                .fallbackToDestructiveMigration() // Очищает и пересоздает базу при смене версии
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
