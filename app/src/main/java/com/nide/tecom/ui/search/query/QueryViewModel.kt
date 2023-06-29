package com.nide.tecom.ui.search.query

import androidx.lifecycle.viewModelScope
import com.nide.tecom.core.base.BaseViewModel
import com.nide.tecom.data.local.SearchItem
import com.nide.tecom.data.repository.RecentSearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QueryViewModel @Inject constructor(
    private val resentRep: RecentSearchRepository
) : BaseViewModel() {

    var recentSearch = resentRep.getItem()






    fun submitItem(name: String) = viewModelScope.launch(Dispatchers.IO) {
        resentRep.adItem(SearchItem(name))
    }


}