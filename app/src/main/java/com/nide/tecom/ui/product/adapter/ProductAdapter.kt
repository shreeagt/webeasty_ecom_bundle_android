package com.nide.tecom.ui.product.adapter

import android.graphics.Color
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nide.tecom.R
import com.nide.tecom.data.model.ShowProductModel
import com.nide.tecom.databinding.ItemProductLayoutBinding
import com.nide.tecom.util.binding

class ProductAdapter (private val onClick : (()->Unit)? = null) :
    ListAdapter<ShowProductModel, ProductAdapter.ProductViewHolder>(diffCallback) {

    private companion object {
        val diffCallback = object : DiffUtil.ItemCallback<ShowProductModel>() {
            override fun areItemsTheSame(
                oldItem: ShowProductModel,
                newItem: ShowProductModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ShowProductModel,
                newItem: ShowProductModel
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return parent.binding<ItemProductLayoutBinding>(R.layout.item_product_layout, false).let(
            ::ProductViewHolder
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }

    inner class ProductViewHolder(private val binding: ItemProductLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

            init {

                binding.root.setOnClickListener {
                   onClick?.invoke()
                }
            }

    }
}