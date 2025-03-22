package com.kotlin.kotlin_mission.dto

import jakarta.validation.constraints.Min

data class RequestUpdateDTO(
    val orderSts: Int,
    val items: List<OrderDTO>
)