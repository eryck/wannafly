package com.example.wannafly.domain.repository

import com.example.wannafly.domain.model.Flight

interface FlightsRepository {
    suspend fun getFlights(): List<Flight>
}