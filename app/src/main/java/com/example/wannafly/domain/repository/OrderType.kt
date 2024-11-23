package com.example.wannafly.domain.repository

sealed interface OrderType {
    data object Ascending: OrderType
    data object Descending: OrderType
}