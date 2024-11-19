package com.example.wannafly.data.remote.network

import com.example.wannafly.data.remote.api.HttpRoutes
import com.example.wannafly.data.remote.api.WebService
import com.example.wannafly.data.remote.response.ApiResponse
import com.example.wannafly.data.remote.response.FlightsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.url

class WebServiceImpl(
    private val httpClient: HttpClient
) : WebService {

    override suspend fun getFlights(): ApiResponse<FlightsResponse> {
        return try {
            val response = httpClient.get { url(HttpRoutes.FLIGHTS) }
            val body = response.body<FlightsResponse>()
            ApiResponse(statusCode = response.status.value, data = body)
        } catch (e: RedirectResponseException) {
            println("Error: ${e.response.status.description}")
            ApiResponse(statusCode = e.response.status.value, data = null, error = e.response.status.description)
        } catch (e: ClientRequestException) {
            println("Error: ${e.response.status.description}")
            ApiResponse(statusCode = e.response.status.value, data = null, error = e.response.status.description)
        } catch (e: ServerResponseException) {
            println("Error: ${e.response.status.description}")
            ApiResponse(statusCode = e.response.status.value, data = null, error = e.response.status.description)
        } catch (e: Exception) {
            println("Error: ${e.message}")
            ApiResponse(statusCode = 500, data = null, error = e.message)
        }
    }
}