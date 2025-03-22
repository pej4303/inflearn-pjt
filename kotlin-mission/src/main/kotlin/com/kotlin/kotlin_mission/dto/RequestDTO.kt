package com.kotlin.kotlin_mission.dto

data class RequestDTO(
    val orderSts: String,
    val items: List<OrderDTO>
)