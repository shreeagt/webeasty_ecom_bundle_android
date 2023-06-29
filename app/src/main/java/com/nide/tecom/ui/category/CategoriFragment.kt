package com.nide.tecom.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nide.tecom.R
import com.nide.tecom.core.base.BaseFragment
import com.nide.tecom.databinding.FragmentCategoriBinding
import com.nide.tecom.ui.category.adapter.ProductCategoryAdapter
import com.nide.tecom.util.observeFlow
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class CategoriFragment : BaseFragment<FragmentCategoriBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_categori

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentCategoriBinding
        get() = DataBindingUtil::inflate

    private val catAdapter by lazy { ProductCategoryAdapter { findNavController().navigate(R.id.action_item_cat_to_productFragment) } }

    private val viewModel: CategoryViewModel by viewModels()


    override fun setUP() {

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            rvCat.adapter = catAdapter
        }

        observeFlow(viewModel.categoryList) {
//            catAdapter.submitList(it)
        }

    }

}