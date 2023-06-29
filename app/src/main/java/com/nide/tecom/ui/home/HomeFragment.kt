package com.nide.tecom.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import com.nide.tecom.R
import com.nide.tecom.core.base.BaseFragment
import com.nide.tecom.databinding.FragmentHomeBinding
import com.nide.tecom.ui.home.adapter.CategoriAdapter
import com.nide.tecom.ui.home.adapter.ProductAdapter


class HomeFragment : BaseFragment<FragmentHomeBinding>() {



    override val layoutRes: Int
        get() = R.layout.fragment_home

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = DataBindingUtil::inflate


    private val categoryAdapter by lazy { CategoriAdapter() }
    private val showProductAdapter by lazy{ ProductAdapter() }

    override fun setUP() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            rvCategory.adapter = categoryAdapter
            rvLProduct.adapter = showProductAdapter
        }


    }


}