package com.nide.tecom.ui.account

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.nide.tecom.R
import com.nide.tecom.core.base.BaseFragment
import com.nide.tecom.core.model.SettingModel
import com.nide.tecom.databinding.FragmentAccountBinding
import com.nide.tecom.ui.account.adapter.SettingAdpater
import com.nide.tecom.ui.address.AddressActivity
import com.nide.tecom.ui.order.OrdersActivity
import com.nide.tecom.util.openActivity


class AccountFragment : BaseFragment<FragmentAccountBinding>(), MenuProvider {


    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.clear()
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return false
    }

    override val layoutRes: Int
        get() = R.layout.fragment_account

    private val adapter by lazy { SettingAdpater() }


    override fun setUP() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            llProfile.btnEdit.setOnClickListener {
                findNavController().navigate(R.id.action_item_account_to_editProfileFragment)
            }
            rvSetting.adapter = adapter
        }

        (requireActivity() as MenuHost).addMenuProvider(this, viewLifecycleOwner)
        adapter.submitList(demoSeting())
    }

    fun demoSeting() = listOf(
        SettingModel(
            R.drawable.ic_round_favorite_border,
            resources.getColor(R.color.black, null),
            "My WishList",
            "View your wishlist and continue shopping"
        ) {
            findNavController().navigate(R.id.favoriteFragment)
        },
        SettingModel(
            R.drawable.outline_add_location_alt,
            resources.getColor(R.color.black, null),
            "Manage Addresses",
            "Manage your delivery , billing address here",
        ) {
            Intent(requireContext(), AddressActivity::class.java).apply {
                startActivity(this)
            }
        },
        SettingModel(
            R.drawable.outline_shopping_cart,
            resources.getColor(R.color.black, null),
            "My Orders",
            "Online Orders, Purchase history"
        ) {
            openActivity(OrdersActivity::class.java)
        },
        SettingModel(
            R.drawable.round_power_settings,
            resources.getColor(R.color.red, null),
            "Logout",
            null
        )

    )


    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentAccountBinding
        get() = DataBindingUtil::inflate
}