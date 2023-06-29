package com.nide.tecom.data.model

data class ShowProductModel(
    val id : String,
    val name:  String,
    val about : String,
    val image : String,
    val price : Float,
    val isOffer : Boolean,
    val offerValue: Int,
    val originalPrice : Float
) {
}