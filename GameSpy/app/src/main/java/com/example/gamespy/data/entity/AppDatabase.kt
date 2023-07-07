package com.example.gamespy.data.entity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gamespy.data.entity.relation.InfoWithPlaces

@Database(entities = [Info::class, Place::class], version = 12)
abstract class AppDatabase : RoomDatabase() {

    abstract fun daoInfo(): DaoInfo

    companion object {
        private var instance: AppDatabase? = null


        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "game_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance as AppDatabase
        }
    }
}