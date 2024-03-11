package com.example.dodosimplified.model

interface Menu {
    val title: String
    val description: String
    val imageRes: Int
    val price: Int
    enum class Type(value: Int) { Pizza(0), Combo(1), Dodster(2)}
    fun getItemListType(): Int

}