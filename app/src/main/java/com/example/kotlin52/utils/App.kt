package com.example.kotlin52.utils

import android.app.Application
import androidx.room.Room
import com.example.kotlin52.data.local.room.entites.Database

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            Database::class.java,
            "my_database"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    companion object {

        lateinit var database: Database
            private set
    }
}