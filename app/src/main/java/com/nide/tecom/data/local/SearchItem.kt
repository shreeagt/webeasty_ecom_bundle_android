package com.nide.tecom.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nide.tecom.data.local.SearchItem.Companion.TABLE_NAME


@Entity(tableName = TABLE_NAME )
data class SearchItem(
    @PrimaryKey(autoGenerate = false) val itemName: String
){
    companion object{
        const val TABLE_NAME = "SEARCH_ITEM"
    }
}
