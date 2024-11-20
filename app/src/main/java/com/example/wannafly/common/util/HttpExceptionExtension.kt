package com.example.wannafly.common.util

import com.example.wannafly.R
import com.example.wannafly.common.UiText

fun CustomHttpException.toErrorMessage(): UiText {
    return if(localizedMessage.isNullOrEmpty()) {
        UiText.Resource(R.string.an_unexpected_error_occured)
    } else {
        UiText.Dynamic(localizedMessage)
    }
}