package com.example.midkaprep.model


data class Car (
    val id: String,
    val model: String,
    val manufacturer: String,
    val img:String,
    val price: Int,
    val wiki: String,
    val isFavourite: Boolean = false
)


