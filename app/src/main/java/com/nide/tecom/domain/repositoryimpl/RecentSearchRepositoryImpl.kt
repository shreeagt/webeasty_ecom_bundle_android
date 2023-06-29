package com.nide.tecom.domain.repositoryimpl

import com.nide.tecom.data.local.SearchItem
import com.nide.tecom.data.local.dao.SearchDao
import com.nide.tecom.data.repository.RecentSearchRepository
import kotlinx.coroutines.flow.Flow

class RecentSearchRepositoryImpl(private val dao: SearchDao) : RecentSearchRepository {

    override  fun adItem(item: SearchItem) {
        dao.insert(item)
    }

    override  fun delteItem(item: SearchItem) {
        dao.delete(item)
    }

    override  fun getItem(): Flow<List<SearchItem>> {
        return dao.getitem()
    }
}