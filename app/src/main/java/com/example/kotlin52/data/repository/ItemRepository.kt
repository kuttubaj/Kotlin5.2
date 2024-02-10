package com.example.kotlin52.data.repository

import com.example.kotlin52.R
import com.example.kotlin52.data.models.Item
import com.example.kotlin52.utils.App

class ItemRepository {

    fun getItem() = App.database.itemDao().getAllItems()

    fun addItem(item: Item){
        App.database.itemDao().addItem(item)
    }
}