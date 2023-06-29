package com.nide.tecom.ui.order.myorders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.nide.tecom.R
import com.nide.tecom.core.base.BaseFragment
import com.nide.tecom.databinding.FragmentMyOrdersBinding
import com.nide.tecom.ui.order.adapter.OrderAdapter


class MyOrdersFragment : BaseFragment<FragmentMyOrdersBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_my_orders

    private val adapter by lazy { OrderAdapter() }

    override fun setUP() {

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            rvOrder.adapter = adapter
        }

    }

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentMyOrdersBinding
        get() = DataBindingUtil::inflate


}