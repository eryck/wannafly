package com.example.wannafly.data.remote.response

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class FlightsResponse(
    @SerialName("flights")
    val flights: List<FlightDTO>,
    val statusCode: Int = 0
)

@Keep
@Serializable
data class FlightDTO(
    @SerialName("flight_id") val id: String,
    @SerialName("status") val status: String,
    @SerialName("completion_status") val completionStatus: String,
    @SerialName("start_date") val startDate: String,
    @SerialName("end_date") val endDate: String,
    @SerialName("departure_time") val departureTime: String,
    @SerialName("arrival_time") val arrivalTime: String,
    @SerialName("departure_airport") val departureAirport: String,
    @SerialName("arrival_airport") val arrivalAirport: String,
    @SerialName("airplane_name") val airplaneName: String
)
