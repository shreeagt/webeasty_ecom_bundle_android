package com.nide.tecom.ui.address.edit

import android.location.Address
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.nide.tecom.core.base.BaseViewModel
import com.nide.tecom.data.LocalPreference
import com.nide.tecom.data.model.AddressModel
import com.nide.tecom.data.repository.AddressRepository
import com.nide.tecom.domain.repositoryimpl.AddressRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class EditAddressViewModel @Inject constructor(
    private val localPref: LocalPreference,
    private val addressRep : AddressRepository
) : BaseViewModel() {


    private val _selectedAddress = MutableStateFlow<AddressModel?>(null)
    val selectAddress = _selectedAddress.asStateFlow()


    fun setDefAddress(address: AddressModel) = viewModelScope.launch {
        localPref.setAddress(address)
    }

    fun setAddress(address: String) = viewModelScope.launch {
        val addObj = Gson().fromJson(address,AddressModel::class.java)
        _selectedAddress.emit(addObj)
    }

}