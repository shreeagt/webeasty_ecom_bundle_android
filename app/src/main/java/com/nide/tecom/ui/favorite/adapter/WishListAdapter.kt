package com.nide.tecom.ui.favorite.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nide.tecom.R
import com.nide.tecom.data.model.ShowProductModel
import com.nide.tecom.databinding.ItemFavoriteLayoutBinding
import com.nide.tecom.ui.favorite.adapter.WishListAdapter.Companion.diffCallBack
import com.nide.tecom.util.binding

class WishListAdapter :
    ListAdapter<ShowProductModel, WishListAdapter.WishListViewHolder>(diffCallBack) {

    private companion object {
        val diffCallBack = object : DiffUtil.ItemCallback<ShowProductModel>() {
            override fun areItemsTheSame(
                oldItem: ShowProductModel,
                newItem: ShowProductModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ShowProductModel,
                newItem: ShowProductModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishListViewHolder {
        return parent.binding<ItemFavoriteLayoutBinding>(R.layout.item_favorite_layout, false)
            .let(::WishListViewHolder)
    }

    override fun onBindViewHolder(holder: WishListViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it)
        }

    }


    inner class WishListViewHolder(private val binding: ItemFavoriteLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: ShowProductModel) {
            binding.apply {
                showProduct = product
                executePendingBindings()
            }
        }

    }
}