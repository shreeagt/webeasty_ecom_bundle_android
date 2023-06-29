package com.nide.tecom.ui.home.adapter

import android.content.ClipData.Item
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nide.tecom.R
import com.nide.tecom.data.model.CategoriModel
import com.nide.tecom.databinding.ItemCategoriLayoutBinding
import com.nide.tecom.util.binding

class CategoriAdapter : ListAdapter<CategoriModel, CategoriAdapter.CategoriViewHolder>(utilCall) {

    private companion object {
        val utilCall = object : DiffUtil.ItemCallback<CategoriModel>() {
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


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriViewHolder {
        return parent.binding<ItemCategoriLayoutBinding>(R.layout.item_categori_layout, false)
            .let(::CategoriViewHolder)
    }

    override fun onBindViewHolder(holder: CategoriViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10;
    }

    inner class CategoriViewHolder(private val binding: ItemCategoriLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)


}