package com.nide.tecom.data.repository

import com.nide.tecom.data.local.SearchItem
import kotlinx.coroutines.flow.Flow

interface RecentSearchRepository {


     fun adItem(item : SearchItem)
     fun delteItem(item : SearchItem)
     fun getItem() : Flow<List<SearchItem>>

}