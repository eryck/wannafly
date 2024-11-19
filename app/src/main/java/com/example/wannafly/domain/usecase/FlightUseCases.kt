package com.example.wannafly.domain.usecase

import com.example.wannafly.R
import com.example.wannafly.common.RequestResource
import com.example.wannafly.common.UiText
import com.example.wannafly.common.util.CustomHttpException
import com.example.wannafly.common.util.toErrorMessage
import com.example.wannafly.domain.model.Flight
import com.example.wannafly.domain.repository.FlightsRepository
import com.example.wannafly.domain.repository.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

data class FlightUseCases(
    val getFlights: GetFlights
)

class GetFlights(
    private val repository: FlightsRepository
) {

    operator fun invoke(
        orderType: OrderType = OrderType.Descending
    ): Flow<RequestResource<List<Flight>>> = flow {
        try {
            emit(RequestResource.Loading())
            val flights = repository.getFlights()
            emit(RequestResource.Success(flights))
        } catch (e: CustomHttpException) {
            emit(RequestResource.Error(e.toErrorMessage()))
        } catch (e: IOException) {
            emit(RequestResource.Error(UiText.Resource(R.string.check_your_internet_connection)))
        }
    }
}

