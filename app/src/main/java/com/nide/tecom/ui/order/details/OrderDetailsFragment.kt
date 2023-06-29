package com.nide.tecom.ui.order.details


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.nide.tecom.R
import com.nide.tecom.core.base.BaseFragment
import com.nide.tecom.databinding.FragmentOrderDetailsBinding

class OrderDetailsFragment : BaseFragment<FragmentOrderDetailsBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_order_details

    override fun setUP() {


    }

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentOrderDetailsBinding
        get() = DataBindingUtil::inflate


}