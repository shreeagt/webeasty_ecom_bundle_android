package com.nide.tecom.ui.productDetails.adapter

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nide.tecom.R
import com.nide.tecom.databinding.ItemSlideImageBinding
import com.nide.tecom.util.binding

class SlideImageAdapter : RecyclerView.Adapter<SlideImageAdapter.SlideImageViewHolder>() {

    private val urlList = mutableListOf<String>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideImageViewHolder {

        return parent.binding<ItemSlideImageBinding>(R.layout.item_slide_image, false)
            .let(::SlideImageViewHolder)

    }

    override fun onBindViewHolder(holder: SlideImageViewHolder, position: Int) {
        holder.bind(urlList[position])

    }

    override fun getItemCount(): Int {
        return urlList.size
    }

    fun submitList(newList: List<String>) {
        urlList.clear()
        urlList.addAll(newList)
        notifyDataSetChanged()
    }


    inner class SlideImageViewHolder(private val binding: ItemSlideImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(url: String) {
            Glide.with(binding.ivProduct)
                .load(url)
                .into(binding.ivProduct)
        }

    }


}