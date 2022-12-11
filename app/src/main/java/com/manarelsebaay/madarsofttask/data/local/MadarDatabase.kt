package com.manarelsebaay.madarsofttask.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.manarelsebaay.madarsofttask.domain.model.DataEntryInfo


@Database(
    entities = [DataEntryInfo::class],
    version = 1,
)
abstract class MadarDatabase :RoomDatabase(){
    abstract val madarDAO:MadarDAO

    companion object {
        const val DATABASE_NAME = "madar_db"
    }
}