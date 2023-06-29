package com.nide.tecom.ui.category.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nide.tecom.R
import com.nide.tecom.data.model.CategoriModel
import com.nide.tecom.databinding.ItemProductCategoryBinding
import com.nide.tecom.util.binding

class ProductCategoryAdapter(private val onItemSelect: (() -> Unit)? = null) :
    ListAdapter<CategoriModel, ProductCategoryAdapter.ProductCategoryViewHolder>(diffCallback) {

    private companion object {
        val diffCallback = object : DiffUtil.ItemCallback<CategoriModel>() {
            override fun areItemsTheSame(oldItem: CategoriModel, newItem: CategoriModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: CategoriModel,
                newItem: CategoriModel
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCategoryViewHolder {
        return parent.binding<ItemProductCategoryBinding>(R.layout.item_product_category, false)
            .let(::ProductCategoryViewHolder)
    }

    override fun onBindViewHolder(holder: ProductCategoryViewHolder, position: Int) {
//        getItem(position)?.let {
//                holder.bind(it)
//        }

    }

    override fun getItemCount(): Int {
        return 10
    }


    inner class ProductCategoryViewHolder(private val binding: ItemProductCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                onItemSelect?.invoke()
            }
        }

        fun bind(categoryData: CategoriModel) {
            binding.apply {
                category = categoryData
                executePendingBindings()
            }
        }

    }

}