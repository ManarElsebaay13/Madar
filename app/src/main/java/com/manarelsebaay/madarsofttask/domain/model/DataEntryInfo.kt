package com.manarelsebaay.madarsofttask.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "SavedData"
)
data class DataEntryInfo (
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name:String,
    val job:String,
    val gender:String,
    val age:String,)

