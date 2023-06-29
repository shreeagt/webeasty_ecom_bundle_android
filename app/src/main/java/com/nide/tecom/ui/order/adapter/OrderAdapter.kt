package com.nide.tecom.ui.order.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nide.tecom.R
import com.nide.tecom.data.model.OrderModel
import com.nide.tecom.databinding.ItemOrderBinding
import com.nide.tecom.util.binding

class OrderAdapter : ListAdapter<OrderModel,OrderAdapter.OrderViewHolder>(callback){

    private companion object{
        private val callback = object : DiffUtil.ItemCallback<OrderModel>(){
            override fun areItemsTheSame(oldItem: OrderModel, newItem: OrderModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: OrderModel, newItem: OrderModel): Boolean {
                return oldItem.orderId == newItem.orderId
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        return parent.binding<ItemOrderBinding>(R.layout.item_order,false).let(::OrderViewHolder)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 3
    }

    inner class OrderViewHolder(private val binding: ItemOrderBinding) :
        RecyclerView.ViewHolder(binding.root) {
         fun bind(order : OrderModel){

         }

    }
}