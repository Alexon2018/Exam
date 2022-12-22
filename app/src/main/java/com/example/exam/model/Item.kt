package com.example.exam.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.NumberFormat
import java.util.Date

@Entity
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "intrebare")
    val itemIntrebare: String,
    @ColumnInfo(name = "categoria")
    val itemCategoria: String,
    @ColumnInfo(name = "raspuns1")
    val itemRaspuns1: String,
    @ColumnInfo(name = "raspuns2")
    val itemRaspuns2: String,
    @ColumnInfo(name = "bool1")
    val itemBool1: Boolean,
    @ColumnInfo(name = "bool2")
    val itemBool2: Boolean,
    @ColumnInfo(name = "date")
    val itemDate: String
)
