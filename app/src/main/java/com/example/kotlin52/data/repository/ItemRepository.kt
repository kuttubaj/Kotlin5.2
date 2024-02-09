package com.example.kotlin52.data.repository

import com.example.kotlin52.R
import com.example.kotlin52.data.models.Item

class ItemRepository {
private val items = mutableListOf(
    Item(R.drawable.hello, "восстань"),
    Item(R.drawable.hello, "E Ранг"),
    Item(R.drawable.hello, "S ранг")
)
    fun getItem() = items

    fun addItem(item: Item){
        items.add(item)
    }
}