package com.nide.tecom.ui.address.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nide.tecom.core.base.BaseViewModel
import com.nide.tecom.data.LocalPreference
import com.nide.tecom.data.model.AddressModel
import com.nide.tecom.data.repository.AddressRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddAddressViewModel @Inject constructor(
    private val localPref: LocalPreference,
    private val addressRep : AddressRepository
) : BaseViewModel() {


    fun setDefAddress(address: AddressModel) = viewModelScope.launch {
        localPref.setAddress(address)
    }

}