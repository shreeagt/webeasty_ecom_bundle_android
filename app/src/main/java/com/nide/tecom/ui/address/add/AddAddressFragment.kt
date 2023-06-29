package com.nide.tecom.ui.address.add

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nide.tecom.R
import com.nide.tecom.core.base.BaseFragment
import com.nide.tecom.data.model.AddressModel
import com.nide.tecom.databinding.FragmentAddAddressBinding
import com.nide.tecom.databinding.FragmentAddAddressBindingImpl
import com.nide.tecom.util.validInput
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddAddressFragment : BaseFragment<FragmentAddAddressBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_add_address

    private val viewModel: AddAddressViewModel by viewModels()

    override fun setUP() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            btnSave.setOnClickListener {
                if (tiName.editText!!.validInput() &&
                    tiPhone.editText!!.validInput() &&
                    tiPin.editText!!.validInput() &&
                    tiAddress.editText!!.validInput() &&
                    tiCity.editText!!.validInput() &&
                    tiState.editText!!.validInput()
                ) {
                        val address = AddressModel(
                            name = tiName.editText!!.text.toString(),
                            mobile = tiPhone.editText!!.text.toString(),
                            pin = tiPin.editText!!.text.toString(),
                            address = tiAddress.editText!!.text.toString(),
                            email = "demo@gmail.com",
                            city = tiCity.editText!!.text.toString(),
                            state = tiState.editText!!.text.toString()
                        )
                    if (isDefault.isChecked) {
                        address.isDefault = true
                        viewModel.setDefAddress(address)
                        findNavController().navigateUp()
                    }
                }
            }
        }

    }

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentAddAddressBinding
        get() = DataBindingUtil::inflate
}