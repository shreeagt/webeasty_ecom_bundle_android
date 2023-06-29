package com.nide.tecom.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nide.tecom.data.local.SearchItem
import com.nide.tecom.data.local.dao.SearchDao


@Database(entities = [SearchItem::class], version = 1)
abstract class SearchDatabase : RoomDatabase() {

    abstract fun searchDao(): SearchDao

}