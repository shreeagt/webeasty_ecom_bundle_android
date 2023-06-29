package com.nide.tecom.ui.payment.checkout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nide.tecom.R
import com.nide.tecom.core.base.BaseFragment
import com.nide.tecom.databinding.FragmentCheckoutBinding
import com.nide.tecom.ui.payment.PaymentViewModel
import com.nide.tecom.util.observeFlow
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class CheckoutFragment : BaseFragment<FragmentCheckoutBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_checkout

    private val viewModel: PaymentViewModel by activityViewModels()


    override fun setUP() {

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            btnChange.setOnClickListener {
                findNavController().navigate(R.id.action_checkoutFragment_to_selectAddressFragment)
            }
        }


        observeData()

    }

    private fun observeData() {
        observeFlow(viewModel.addresses) {
            if (it.isEmpty()) {
                binding?.apply {
                    btnChange.text = "add address"
                    btnChange.setOnClickListener {
                        findNavController().navigate(R.id.action_checkoutFragment_to_addAddressFragment2)
                    }
                    llAddress.isVisible = false
                }
            } else {
                val address = it[viewModel.selectedAddress.value]
                binding?.apply {
                    btnChange.text = "change"
                    btnChange.setOnClickListener {
                        findNavController().navigate(R.id.action_checkoutFragment_to_selectAddressFragment)
                    }
                    tvAddName.text = address.name
                    tvAddMobile.text = address.mobile
                    tvAdd.text =
                        "${address.address},${address.city},${address.state},${address.pin}"

                    llAddress.isVisible = true
                }
            }
        }

        viewModel.getDefaultAddress().observe(this){
            it?.let {
                Timber.i("default address $it")
                viewModel.setAddress(listOf(it,it))
            }
        }
    }

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentCheckoutBinding
        get() = DataBindingUtil::inflate
}