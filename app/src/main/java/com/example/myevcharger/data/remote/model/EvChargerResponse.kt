package com.example.myevcharger.data.remote.model

data class EvChargerResponse(
    val evChargers: MutableList<EvChargerApiModel>,
    val status: String,
    val totalResults: Int
)
