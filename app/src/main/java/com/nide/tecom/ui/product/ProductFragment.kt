package com.nide.tecom.ui.product

import android.content.Intent
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.nide.tecom.R
import com.nide.tecom.core.base.BaseFragment
import com.nide.tecom.databinding.FragmentProductBinding
import com.nide.tecom.ui.product.adapter.ProductAdapter
import com.nide.tecom.ui.productDetails.ProductDetailsActivity
import com.nide.tecom.ui.search.SearchActivity
import com.nide.tecom.util.openActivity

class ProductFragment : BaseFragment<FragmentProductBinding>(), MenuProvider {

    override val layoutRes: Int
        get() = R.layout.fragment_product


    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentProductBinding
        get() = DataBindingUtil::inflate

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.clear()
        menuInflater.inflate(R.menu.toolbar_menu, menu)
    }

    private val adapter by lazy { ProductAdapter{openActivity(ProductDetailsActivity::class.java)}  }


    override fun setUP() {
        (requireActivity() as MenuHost).addMenuProvider(this, viewLifecycleOwner)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            rvProduct.adapter = adapter
        }
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.item_search -> {
                Intent(requireContext(),SearchActivity::class.java).apply {
                    startActivity(this)
                }
                true
            }
            R.id.item_favorite -> {
                findNavController().navigate(R.id.favoriteFragment)
                true
            }
            R.id.item_bag -> {
                findNavController().navigate(R.id.cartFragment)
                true
            }
            else -> false
        }

    }



}