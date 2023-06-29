package com.nide.tecom.data.local.dao

import androidx.room.*
import com.nide.tecom.data.local.SearchItem
import com.nide.tecom.data.local.SearchItem.Companion.TABLE_NAME
import kotlinx.coroutines.flow.Flow

@Dao
interface SearchDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: SearchItem)

    @Delete
    fun delete(item: SearchItem)

    @Query("SELECT * FROM $TABLE_NAME ORDER BY itemName DESC LIMIT 5 ")
    fun getitem(): Flow<List<SearchItem>>


}