package com.nide.tecom.ui.cart.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nide.tecom.R
import com.nide.tecom.data.model.CartItemModel
import com.nide.tecom.databinding.ItemCartProductBinding
import com.nide.tecom.util.binding

class CartAdapter : ListAdapter<CartItemModel, CartAdapter.CartItemViewHolder>(diffCallback) {

    private companion object {
        val diffCallback = object : DiffUtil.ItemCallback<CartItemModel>() {
            override fun areItemsTheSame(oldItem: CartItemModel, newItem: CartItemModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: CartItemModel,
                newItem: CartItemModel
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        return parent.binding<ItemCartProductBinding>(R.layout.item_cart_product, false).let(
            ::CartItemViewHolder
        )
    }

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it)
        }

    }


    inner class CartItemViewHolder(private val binding: ItemCartProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(cartItem : CartItemModel){
                binding.apply {
                    cart = cartItem
                    executePendingBindings()
                }
            }



    }
}