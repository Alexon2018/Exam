package com.example.exam.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.NumberFormat

@Entity
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "intrebare")
    val itemIntrebare: String,
    @ColumnInfo(name = "raspuns1")
    val itemRaspuns1: String,
    @ColumnInfo(name = "raspuns2")
    val itemRaspuns2: String
//    @ColumnInfo(name = "price")
//    val itemPrice: Double,
//    @ColumnInfo(name = "quantity")
//    val quantityInStock: Int

)

//fun Item.getFormattedPrice(): String =
//    NumberFormat.getCurrencyInstance().format(itemPrice)
