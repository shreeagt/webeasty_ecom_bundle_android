package com.nide.tecom.ui.payment.change_address

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.nide.tecom.R
import com.nide.tecom.core.base.BaseFragment
import com.nide.tecom.data.model.AddressModel
import com.nide.tecom.databinding.FragmentSelectAddressBinding
import com.nide.tecom.ui.payment.PaymentViewModel
import com.nide.tecom.ui.payment.change_address.adapter.ManageAddressAdapter
import com.nide.tecom.util.observeFlow
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SelectAddressFragment : BaseFragment<FragmentSelectAddressBinding>() {


    private var selectedAddress: Int = 0

    override val layoutRes: Int
        get() = R.layout.fragment_select_address

    private val adapter by lazy {
        ManageAddressAdapter(viewModel.selectedAddress.value) {
            selectedAddress = it
        }
    }

    private val viewModel: PaymentViewModel by activityViewModels()


    override fun setUP() {

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            rvAddress.adapter = adapter
            btnProceed.setOnClickListener {
                viewModel.setSelectAddress(selectedAddress)
                findNavController().navigateUp()
            }
            btnAddAddress.setOnClickListener {
                findNavController().navigate(R.id.action_selectAddressFragment_to_addAddressFragment)
            }

        }
        adapter.submitList(viewModel.getDemoData())
        observeData()
    }

    private fun observeData() {
        observeFlow(viewModel.selectedAddress) {
            selectedAddress = it
        }
    }

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentSelectAddressBinding
        get() = DataBindingUtil::inflate


}