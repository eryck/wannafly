package com.example.wannafly.common

import android.content.Context
import androidx.annotation.StringRes

sealed class UiText {
    data class Dynamic(val text: String) : UiText()
    data class Resource(@StringRes val id: Int) : UiText()

    fun toString(context: Context): String {
        return when(this) {
            is Dynamic -> this.text
            is Resource -> context.resources.getString(id)
        }
    }
}