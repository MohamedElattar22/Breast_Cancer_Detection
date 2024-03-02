package com.graduation.breastcancer.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ReportDao::class], version = 1, exportSchema = true)
abstract class MyDatabase : RoomDatabase() {
    abstract fun reportDao(): ReportDao

    companion object {
        private var instance: MyDatabase? = null //

        fun getInstance(context: Context): MyDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext, MyDatabase::class.java, "tasksDataBase"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        }
    }
}