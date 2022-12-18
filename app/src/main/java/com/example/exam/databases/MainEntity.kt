package com.example.exam.databases

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions_prof_table")

data class MainEntity (

    @PrimaryKey(autoGenerate = true)
    var entryID: Long = 0L,

    @ColumnInfo(name = "question")
    val startTimeMilli: String = "",

    @ColumnInfo(name = "b1")
    var sleepQuality: Boolean = false

    )
