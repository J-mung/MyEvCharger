package com.example.myevcharger.data.model

data class EvChargerResponse(
    val evCharger: MutableList<EvCharger>,
    val status: String,
    val totalResults: Int
)
