package com.example.myevcharger.domain.model

data class EvChargerResponse(
    val evChargers: MutableList<EvCharger>,
    val status: String,
    val totalResults: Int
)
