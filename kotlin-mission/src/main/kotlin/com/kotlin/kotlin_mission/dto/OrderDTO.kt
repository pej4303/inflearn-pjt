package com.kotlin.kotlin_mission.dto

import jakarta.validation.constraints.Min


data class OrderDTO(
    val productCd: Long,  // 상품코드
    @field:Min(value = 1, message = "가격은 1 이상이어야 합니다.")
    val price: Int,    // 가격
    @field:Min(value = 1, message = "수량은 1 이상이어야 합니다.")
    val qty: Int,      // 수량
    val memo: String?   // 메모
)