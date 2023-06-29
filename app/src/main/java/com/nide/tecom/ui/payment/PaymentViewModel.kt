package com.nide.tecom.ui.payment

import androidx.lifecycle.viewModelScope
import com.nide.tecom.core.base.BaseViewModel
import com.nide.tecom.data.LocalPreference
import com.nide.tecom.data.model.AddressModel
import com.nide.tecom.data.repository.AddressRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class PaymentViewModel @Inject constructor(
    private val localPreference: LocalPreference,
    private val addressRep: AddressRepository
) : BaseViewModel() {

    private val _selectedAddress = MutableStateFlow(0)
    val selectedAddress = _selectedAddress.asStateFlow()

    private val _addresses = MutableStateFlow<List<AddressModel>>(emptyList())
    val addresses = _addresses.asStateFlow()


    init {
        getDefaultAddress()
    }


    fun getDefaultAddress() = localPreference.getAddress()

    fun setAddress(addressed: List<AddressModel>) = viewModelScope.launch {
        _addresses.emit(addressed)
    }


    fun setSelectAddress(addressModelPosition: Int) = viewModelScope.launch {
        _selectedAddress.emit(addressModelPosition)
    }

    fun getDemoData() = listOf(
        AddressModel(
            "Nitisha Das",
            "Subhasgram chanditala park",
            "700147",
            "kolkata",
            "WestBengal",
            "9836742862",
            "demo@gmail.com"
        ),
        AddressModel(
            "Debashis Halder",
            "Subhasgram chanditala , south 24 paragana,westbengal, 700147",
            "700147",
            "kolkata",
            "WestBengal",
            "9836742862",
            "demo@gmail.com"
        )
    )

}