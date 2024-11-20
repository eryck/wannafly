package com.example.wannafly.data.remote.response

data class SignInResultResponse(
    val data: UserDataResponse?,
    val errorMessage: String?
)

data class UserDataResponse(
    val userId: String,
    val username: String?,
    val profileImageUrl: String?
)