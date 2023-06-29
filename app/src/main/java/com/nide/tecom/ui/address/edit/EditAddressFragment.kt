package com.nide.tecom.ui.address.edit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.nide.tecom.R
import com.nide.tecom.core.base.BaseFragment
import com.nide.tecom.core.base.BaseViewModel
import com.nide.tecom.databinding.FragmentEditAddressBinding
import com.nide.tecom.util.observeFlow
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class EditAddressFragment : BaseFragment<FragmentEditAddressBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_edit_address

    private val viewModel: EditAddressViewModel by viewModels()

    private val args: EditAddressFragmentArgs by navArgs()

    override fun setUP() {

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
        }

        viewModel.setAddress(args.address)
        observeData()

    }

    private fun observeData() {
        observeFlow(viewModel.selectAddress) {
            it?.let { address ->
                binding?.apply {
                    add = address
                }
            }
        }
    }

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentEditAddressBinding
        get() = DataBindingUtil::inflate
}