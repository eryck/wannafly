package com.example.wannafly.ui.flights

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wannafly.common.RequestResource
import com.example.wannafly.domain.usecase.FlightUseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class FlightsViewModel(
    private val flightUseCases: FlightUseCases
) : ViewModel() {

    private val _uiState = MutableStateFlow<FlightsUiState>(FlightsUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        on(FlightsEvent.Start)
    }

    fun on(event: FlightsEvent) {
        when (event) {
            is FlightsEvent.Start -> getFlights()
        }
    }

    private fun getFlights() {
        flightUseCases.getFlights().onEach { currentResult ->

            _uiState.value = when (currentResult) {
                is RequestResource.Success -> FlightsUiState.Success(currentResult.data!!)
                is RequestResource.Error -> FlightsUiState.TryAgain(currentResult.message)
                is RequestResource.Loading -> FlightsUiState.Loading
            }
        }.launchIn(viewModelScope)
    }
}