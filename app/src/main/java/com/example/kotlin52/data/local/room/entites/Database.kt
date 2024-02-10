package com.example.kotlin52.data.local.room.entites

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlin52.data.models.Item

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {

    abstract fun itemDao(): ItemDao

}