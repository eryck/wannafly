package com.example.wannafly.ui.flights

import com.example.wannafly.common.UiText
import com.example.wannafly.domain.model.Flight

sealed class FlightsUiState {
    data class Success(val flights: List<Flight>) : FlightsUiState()
    data object Loading : FlightsUiState()
    data class TryAgain(val errorMessage: UiText?) : FlightsUiState()
}
