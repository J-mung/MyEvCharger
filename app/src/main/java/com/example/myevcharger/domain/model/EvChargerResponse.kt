package com.example.myevcharger.domain.model

data class EvChargerResponse(
    val evCharger: MutableList<EvCharger>,
    val status: String,
    val totalResults: Int
)
