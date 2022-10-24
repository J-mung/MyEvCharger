package com.example.myevcharger.data.remote.model

import com.example.myevcharger.domain.model.EvCharger

data class EvChargerResponse(
    val evChargers: MutableList<EvCharger>,
    val status: String,
    val totalResults: Int
)
