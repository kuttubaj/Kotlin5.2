package com.example.kotlin52.data.models

import androidx.annotation.DrawableRes

data class Item(
    @DrawableRes
    val image: Int,
    val name: String
)
