package com.walaa.shaaban.mvvmarchitecturepattern.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.walaa.shaaban.mvvmarchitecturepattern.data.model.FlowerResponse

@Database(entities = [FlowerResponse::class], version = 5, exportSchema = false)
abstract class FlowerDatabase : RoomDatabase(){

    abstract fun flowerDao(): FlowerDao

    companion object {
        @Volatile
        private var instance: FlowerDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }
        //Access Database
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            FlowerDatabase::class.java, "flowers.db"
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()


    }

}