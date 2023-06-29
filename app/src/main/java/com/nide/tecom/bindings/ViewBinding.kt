package com.nide.tecom.bindings

import android.content.res.ColorStateList
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.isVisible
import androidx.core.widget.CompoundButtonCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.findViewTreeLifecycleOwner
import com.bumptech.glide.Glide

import com.google.android.material.card.MaterialCardView
import com.nide.tecom.R
import com.nide.tecom.core.state.UiState
import timber.log.Timber

object ViewBinding {


    @JvmStatic
    @BindingAdapter("loadImage")
    fun AppCompatImageView.loadimage(url: String?) {
        Glide.with(this)
            .load(url)
            .error(R.drawable.shirt)
            .into(this)
    }


    @JvmStatic
    @BindingAdapter("set_float")
    fun AppCompatTextView.setFloat(value: Float) {
        text = value.toString()
    }

    @JvmStatic
    @BindingAdapter("onBackPressed")
    fun View.bindOnBackPressed(onBackPress: Boolean) {
        val context = context
        if (onBackPress && context is OnBackPressedDispatcherOwner) {
            setOnClickListener {
                context.onBackPressedDispatcher.onBackPressed()
            }
        }
    }


    @JvmStatic
    @BindingAdapter("showIfError")
    fun View.showIfError(state: UiState) {
        Timber.tag("Course").i("showIfError: ${state.toString()} : View = ${this.id}")
        this.isVisible = (state is UiState.Error)
    }

    @JvmStatic
    @BindingAdapter("showIfSuccess")
    fun View.showIfSuccess(state: UiState) {
        Timber.tag("Course")
            .i("showIfsuccess: ${state.toString()} :: state:${(state is UiState.Success)}")
        this.isVisible = (state is UiState.Success)
    }

    @JvmStatic
    @BindingAdapter("showIfLoading")
    fun showIfLoading(view: View, state: UiState) {
        view.isVisible = (state is UiState.Loading)
    }


    @JvmStatic
    @BindingAdapter("make_visible")
    fun View.makeVisible(state: Boolean) {
        this.isVisible = state
    }
}