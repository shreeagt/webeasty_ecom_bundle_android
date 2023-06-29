package com.nide.tecom.ui.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nide.tecom.R
import com.nide.tecom.data.model.ShowProductModel
import com.nide.tecom.databinding.ItemProductLayoutBinding
import com.nide.tecom.databinding.ItemShowProductLayoutBinding
import com.nide.tecom.util.binding

class ProductAdapter : ListAdapter<ShowProductModel,ProductAdapter.ProductViewHolder>(diffCallback) {

    private companion object{
        val diffCallback = object : DiffUtil.ItemCallback<ShowProductModel>(){
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
        return parent.binding<ItemShowProductLayoutBinding>(R.layout.item_show_product_layout,false).let(::ProductViewHolder)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }


    inner class ProductViewHolder(private val binding: ItemShowProductLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}