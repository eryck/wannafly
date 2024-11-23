package com.example.wannafly.common.util

data class CustomHttpException(
    val statusCode: Int,
    val errorMessage: String?
) : Exception(errorMessage)