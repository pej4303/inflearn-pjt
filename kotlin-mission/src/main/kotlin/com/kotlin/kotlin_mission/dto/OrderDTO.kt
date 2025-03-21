package com.kotlin.kotlin_mission.dto

import jakarta.validation.constraints.Min

data class OrderDTO(
    val productCd: Long,
    @field:Min(value = 1, message = "가격은 1 이상이어야 합니다.")
    val price: Int,
    @field:Min(value = 1, message = "수량은 1 이상이어야 합니다.")
    val qty: Int,
    val memo: String
)