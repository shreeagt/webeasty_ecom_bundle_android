package com.nide.tecom.core.response

data class PageResponse<T>(
    val limit: Int?,
    val page: Int,
    val totalPages: Int,
    val result: List<T>
)