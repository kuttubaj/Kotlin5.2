package com.example.kotlin52.data.local.room.entites

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlin52.data.models.Item

@Dao
interface ItemDao {
    @Query("SELECT * FROM  item_table")
    fun getAllItems(): List<Item>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addItem(item: Item)

    @Query("DELETE FROM item_table")
    fun clear()
}