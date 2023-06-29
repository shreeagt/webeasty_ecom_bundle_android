package com.nide.tecom.data.model

data class AddressModel(
    val name: String,
    val address: String,
    val pin : String,
    val city: String,
    val state : String,
    val mobile: String,
    val email : String?=null,
    var isDefault : Boolean = false
) {
}