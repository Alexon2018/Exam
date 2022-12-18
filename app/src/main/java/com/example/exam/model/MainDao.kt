package com.example.exam.model

import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface MainDao {

//    @Insert
//    fun insert(night: SleepNight)
//
//    @Update
//    fun update(night: SleepNight)

    @Query("SELECT * from questions_prof_table")
    fun getAll(): Flow<List<MainEntity>>

//    @Query("SELECT * from questions_prof_table WHERE entryID = :key")
//    fun get(key: Long): MainEntity?

//    @Query("DELETE FROM daily_sleep_quality_table")
//    fun clear()
//
//    @Query("SELECT * FROM daily_sleep_quality_table ORDER BY nightId DESC LIMIT 1")
//    fun getTonight(): SleepNight?
//
//    @Query("SELECT * FROM daily_sleep_quality_table ORDER BY nightId DESC")
//    fun getAllNights(): LiveData<List<SleepNight>>
}