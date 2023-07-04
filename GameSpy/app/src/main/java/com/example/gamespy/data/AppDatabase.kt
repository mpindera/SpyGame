package com.example.gamespy.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DataPlace::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun DaoPlace(): DaoPlace

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).fallbackToDestructiveMigration()
                    .build()
            }
            return instance as AppDatabase
        }
    }
}