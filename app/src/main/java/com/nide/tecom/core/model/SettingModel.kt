package com.nide.tecom.core.model

import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.ui.res.colorResource
import com.nide.tecom.R

data class SettingModel(
    @DrawableRes val icon: Int,
  @ColorInt  var tintColor:Int ,
    val title: String,
    val onClick: (() -> Unit)?
) {
    var desText: String = ""

    constructor(
        @DrawableRes icon: Int,
        @ColorInt   tintColor:Int,
        title: String,
        description: String,
        onClick: (() -> Unit)?
    ) : this(icon, tintColor, title, onClick) {
        this.desText = description
    }

}
