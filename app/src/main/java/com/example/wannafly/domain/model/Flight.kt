package com.example.wannafly.domain.model

data class Flight(
    val id: String,
    val status: String,
    val completionStatus: String,
    val startDate: String,
    val endDate: String,
    val departureTime: String,
    val arrivalTime: String,
    val departureAirport: String,
    val arrivalAirport: String,
    val airplaneName: String
)
