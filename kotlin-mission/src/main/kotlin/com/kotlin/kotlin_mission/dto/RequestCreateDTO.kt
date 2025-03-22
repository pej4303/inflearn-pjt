package com.kotlin.kotlin_mission.dto

import jakarta.validation.constraints.Min

data class RequestCreateDTO(
    val items: List<OrderDTO>
)