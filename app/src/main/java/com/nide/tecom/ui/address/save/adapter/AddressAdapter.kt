package com.nide.tecom.ui.address.save.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nide.tecom.R
import com.nide.tecom.data.model.AddressModel
import com.nide.tecom.databinding.ItemAddressBinding
import com.nide.tecom.util.binding
import timber.log.Timber

class AddressAdapter(private val onEditClick: ((AddressModel) -> Unit)?) :
    ListAdapter<AddressModel, AddressAdapter.AddressViewHolder>(callback) {


    private companion object {
        val callback = object : DiffUtil.ItemCallback<AddressModel>() {
            override fun areItemsTheSame(oldItem: AddressModel, newItem: AddressModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: AddressModel, newItem: AddressModel): Boolean {
                return oldItem.name == newItem.name && oldItem.address == newItem.address && oldItem.mobile == newItem.mobile
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        return parent.binding<ItemAddressBinding>(R.layout.item_address, false)
            .let(::AddressViewHolder)
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        val item = getItem(position)
        Timber.i("adapter $item")
        item?.let {
            Timber.i("adapter ; $it")
            holder.bind(it)
        }
    }


    inner class AddressViewHolder(private val binding: ItemAddressBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(address: AddressModel) {
            Timber.i("viewholder: $address")
            binding.add = address
            binding.executePendingBindings()

            binding.btnEdit.setOnClickListener {
                onEditClick?.invoke(address)
            }
        }

    }
}