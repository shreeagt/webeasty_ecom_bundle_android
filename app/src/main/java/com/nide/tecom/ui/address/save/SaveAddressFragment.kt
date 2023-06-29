package com.nide.tecom.ui.address.save

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.nide.tecom.R
import com.nide.tecom.core.base.BaseFragment
import com.nide.tecom.data.model.AddressModel
import com.nide.tecom.databinding.FragmentSaveAddressBinding
import com.nide.tecom.ui.address.save.adapter.AddressAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaveAddressFragment : BaseFragment<FragmentSaveAddressBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_save_address

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentSaveAddressBinding
        get() = DataBindingUtil::inflate

    private val adapter by lazy {
        AddressAdapter{

            val action =
                SaveAddressFragmentDirections.actionSaveAddressFragmentToEditAddressFragment(
                    Gson().toJson(it)
                )

            findNavController().navigate(action)
        }
    }


    override fun setUP() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            rvAddress.adapter = adapter
            llAddContainer.setOnClickListener {
                findNavController().navigate(R.id.action_saveAddressFragment_to_addAddressFragment)
            }


        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.submitList(getDemoAddress())
    }


    private fun getDemoAddress() = listOf(
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