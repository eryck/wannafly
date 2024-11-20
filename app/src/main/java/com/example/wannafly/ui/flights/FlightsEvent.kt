package com.example.wannafly.ui.flights

sealed class FlightsEvent {
    data object Start : FlightsEvent()
}
