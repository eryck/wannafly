package com.example.wannafly.data.repository

import com.example.wannafly.common.util.CustomHttpException
import com.example.wannafly.data.remote.api.WebService
import com.example.wannafly.domain.mapper.FlightMapper
import com.example.wannafly.domain.model.Flight
import com.example.wannafly.domain.repository.FlightsRepository

class FlightsRepositoryImpl(
    private val api: WebService,
    private val mapper: FlightMapper
) : FlightsRepository {

    /**
    Save information while app is running
     */
    companion object CacheLocal {
        lateinit var listFlights: List<Flight>
    }

    override suspend fun getFlights(): List<Flight> {
        val response = api.getFlights()
        if (response.data != null) {
            return mapper.mapToDomain(response.data).apply {
                listFlights = this
            }
        } else {
            throw CustomHttpException(
                statusCode = response.statusCode,
                errorMessage = response.error ?: "Unknown error"
            )
        }
    }

}