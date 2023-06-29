package com.nide.tecom.ui.account.adapter

import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nide.tecom.R
import com.nide.tecom.core.model.SettingModel
import com.nide.tecom.databinding.ItemSettingBinding
import com.nide.tecom.util.binding

class SettingAdpater : ListAdapter<SettingModel, SettingAdpater.SettingViewHolder>(callback) {


    private companion object {
        val callback = object : DiffUtil.ItemCallback<SettingModel>() {
            override fun areItemsTheSame(oldItem: SettingModel, newItem: SettingModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: SettingModel, newItem: SettingModel): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingViewHolder {
        return parent.binding<ItemSettingBinding>(R.layout.item_setting, false)
            .let(::SettingViewHolder)
    }

    override fun onBindViewHolder(holder: SettingViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it)
        }
    }

    inner class SettingViewHolder(private val binding: ItemSettingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(setting: SettingModel) {
            binding.apply {
                config = setting
                tvTitle.setTextColor(setting.tintColor)
                ivIcon.setImageResource(setting.icon)
                root.setOnClickListener {
                    setting.onClick?.invoke()
                }
                tvDes.isVisible = setting.desText.isNotEmpty()
                executePendingBindings()
            }

        }

    }
}