package com.nide.tecom.ui.favorite


import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nide.tecom.R
import com.nide.tecom.core.base.BaseFragment
import com.nide.tecom.databinding.FragmentFavoriteBinding
import com.nide.tecom.ui.favorite.adapter.WishListAdapter
import com.nide.tecom.util.observeFlow
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(), MenuProvider {
    override val layoutRes: Int
        get() = R.layout.fragment_favorite


    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentFavoriteBinding
        get() = DataBindingUtil::inflate

    private val viewModel : FavoriteViewModel by viewModels()

    private val adapter by lazy { WishListAdapter() }


    override fun setUP() {

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            listAdapter = adapter
        }


        (requireActivity() as MenuHost).addMenuProvider(this,viewLifecycleOwner)

        observeFlow(viewModel.wishlist){
            adapter.submitList(it)
        }

    }



    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.clear()
        menuInflater.inflate(R.menu.wishfrag_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.cartFragment -> {
                findNavController().navigate(R.id.cartFragment)
                true
            }
            else -> false

        }
    }
}