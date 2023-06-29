package com.nide.tecom.ui.productDetails.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nide.tecom.R
import com.nide.tecom.data.model.ReviewModel
import com.nide.tecom.databinding.ItemRatingLayoutBinding
import com.nide.tecom.util.binding

class ReviewAdapter : ListAdapter<ReviewModel, ReviewAdapter.ReviewViewHolder>(diffcallback) {

    private companion object {
        private val diffcallback = object : DiffUtil.ItemCallback<ReviewModel>() {
            override fun areItemsTheSame(oldItem: ReviewModel, newItem: ReviewModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ReviewModel, newItem: ReviewModel): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        return parent.binding<ItemRatingLayoutBinding>(R.layout.item_rating_layout, false)
            .let(::ReviewViewHolder)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it)
        }
    }



    inner class ReviewViewHolder(private val binding: ItemRatingLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(review: ReviewModel) {
            binding.apply {
                reviewData = review
                executePendingBindings()
            }


        }


    }

}