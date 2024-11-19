package com.example.wannafly.common

sealed class RequestResource<T>(val data: T? = null, val message: UiText? = null) {
    class Success<T>(data: T) : RequestResource<T>(data)
    class Error<T>(message: UiText, data: T? = null) : RequestResource<T>(data, message)
    class Loading<T>(data: T? = null) : RequestResource<T>(data)
}