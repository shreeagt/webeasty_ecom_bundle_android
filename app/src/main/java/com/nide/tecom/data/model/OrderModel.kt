package com.nide.tecom.data.model

data class OrderModel(
    val orderId: String,
    val name: String,
    val quantity: Int,
    val orderDate: String,
    val totalAmount: String,
    val image: String,
    val status: String
) {
}