package com.example.dodosimplified.model

import java.io.Serializable
import java.util.UUID

data class PizzaCombo(
    val id: String = UUID.randomUUID().toString(),
    val size: Int,
    override val title: String,
    override val description: String,
    override val imageRes: Int,
    override val price:Int
):Menu,Serializable{
    override fun getItemListType(): Int {
        return Menu.Type.Combo.ordinal
    }

}

