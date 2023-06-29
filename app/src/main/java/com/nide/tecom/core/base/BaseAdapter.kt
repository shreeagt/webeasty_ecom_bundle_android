package com.nide.tecom.core.base

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<T , Bind : ViewBinding>(callback: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, BaseAdapter.BaseViewHolder<T>>(callback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        TODO()
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        TODO("Not yet implemented")
    }

    abstract class BaseViewHolder<T>(private val binding: ViewBinding):RecyclerView.ViewHolder(binding.root){

       abstract fun bind(data : T)

    }
}