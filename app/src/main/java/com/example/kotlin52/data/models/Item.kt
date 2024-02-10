package com.example.kotlin52.data.models

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_table")
data class Item(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @DrawableRes
    val image: Int,
    val name: String
)
