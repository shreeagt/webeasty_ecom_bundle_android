package com.nide.tecom.ui.cart

import android.view.*
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nide.tecom.R
import com.nide.tecom.core.base.BaseFragment
import com.nide.tecom.databinding.FragmentCartBinding
import com.nide.tecom.ui.cart.adapter.CartAdapter
import com.nide.tecom.ui.payment.PaymentActivity
import com.nide.tecom.util.observeFlow
import com.nide.tecom.util.openActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : BaseFragment<FragmentCartBinding>(), MenuProvider {

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.clear()
        menuInflater.inflate(R.menu.cart_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.item_favorite -> {
                findNavController().navigate(R.id.favoriteFragment)
                true
            }
            else -> false
        }
    }

    override val layoutRes: Int
        get() = R.layout.fragment_cart
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentCartBinding
        get() = DataBindingUtil::inflate

    private val adapter by lazy { CartAdapter() }
    private val viewModel: CartViewModel by viewModels()


    override fun setUP() {

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            rvCart.adapter = adapter
            btnCheckOut.setOnClickListener {
                openActivity(PaymentActivity::class.java)
            }
        }

        (requireActivity() as MenuHost).addMenuProvider(this, viewLifecycleOwner)

        observeFlow()


    }

    private fun observeFlow() {
        observeFlow(viewModel.cartList) {
            adapter.submitList(it)
        }
        observeFlow(viewModel.errorMessage) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }

    }


}