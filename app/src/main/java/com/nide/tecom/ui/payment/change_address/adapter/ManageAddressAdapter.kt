package com.nide.tecom.ui.payment.change_address.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nide.tecom.R
import com.nide.tecom.data.model.AddressModel
import com.nide.tecom.databinding.ItemSelectedAddressBinding
import com.nide.tecom.util.binding
import timber.log.Timber

class ManageAddressAdapter constructor(private var selectedPosition: Int, private val onSelect : ((Int)->Unit)) : ListAdapter<AddressModel, ManageAddressAdapter.AddressViewHolder>(
    callback
) {


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
        return parent.binding<ItemSelectedAddressBinding>(R.layout.item_selected_address, false)
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


    inner class AddressViewHolder(private val binding: ItemSelectedAddressBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                if (!binding.radioButton.isChecked) {
                    selectedPosition = bindingAdapterPosition
                    onSelect.invoke(selectedPosition)
                    bindingAdapter?.notifyDataSetChanged()

                }
            }
        }

        fun bind(address: AddressModel) {
            Timber.i("position $selectedPosition")
            binding.radioButton.isChecked = bindingAdapterPosition == selectedPosition

        }

    }


}