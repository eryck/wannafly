package com.example.wannafly.data.remote.response

data class ApiResponse<T>(
    val statusCode: Int,
    val data: T?,
    val error: String? = null
)
