package com.nide.tecom.ui.search.result

import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.nide.tecom.R
import com.nide.tecom.core.base.BaseFragment
import com.nide.tecom.databinding.FragmentSearchProductBinding
import com.nide.tecom.ui.product.adapter.ProductAdapter
import com.nide.tecom.ui.productDetails.ProductDetailsActivity
import com.nide.tecom.ui.search.SearchActivity
import com.nide.tecom.util.openActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchProductFragment : BaseFragment<FragmentSearchProductBinding>(), MenuProvider {


    override fun onPrepareMenu(menu: Menu) {
        menu.findItem(R.id.item_search).isVisible = false
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
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

    override val layoutRes: Int
        get() = R.layout.fragment_search_product

    private val args: SearchProductFragmentArgs by navArgs()

    private val viewModel: SearchResultViewModel by viewModels()
    private val adapter by lazy { ProductAdapter{openActivity(ProductDetailsActivity::class.java)} }

    override fun setUP() {

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            rvProduct.adapter = adapter
        }

        (requireActivity() as SearchActivity).apply {
            supportActionBar?.title = "Search for '${args.query}'"
            (this as MenuHost).addMenuProvider(this@SearchProductFragment, viewLifecycleOwner)

        }

    }

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentSearchProductBinding
        get() = DataBindingUtil::inflate


}