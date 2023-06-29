package com.nide.tecom.ui.address.save

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nide.tecom.data.LocalPreference
import com.nide.tecom.data.model.AddressModel
import com.nide.tecom.data.repository.AddressRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SaveAddressViewModel @Inject constructor(
    private val localPref: LocalPreference,
    private val addressRep : AddressRepository
) : ViewModel() {


    fun setAddress(address: AddressModel) = viewModelScope.launch {
        localPref.setAddress(address)
    }


}