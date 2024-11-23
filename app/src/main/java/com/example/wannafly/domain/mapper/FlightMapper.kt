package com.example.wannafly.domain.mapper

import com.example.wannafly.data.remote.response.FlightsResponse
import com.example.wannafly.domain.model.Flight

class FlightMapper {

    fun mapToDomain(response: FlightsResponse): List<Flight> {
        return response.flights.map {
            Flight(
                id = it.id,
                status = it.status,
                completionStatus = it.completionStatus,
                startDate = it.startDate,
                endDate = it.endDate,
                departureTime = it.departureTime,
                arrivalTime = it.arrivalTime,
                departureAirport = it.departureAirport,
                arrivalAirport = it.arrivalAirport,
                airplaneName = it.airplaneName
            )
        }
    }
}