package com.kotlin.kotlin_mission.dto

import java.time.LocalDateTime
data class OrderDetailDTO(
    val orderNo: Long,
    val orderLineNo: String,
    val orderSts: Int,
    val productCd: String,
    val productNm: String,
    val price: Int,
    val qty: Int,
    val vat: Int,
    val totalPrice: Int,
    val createdDt: String,
    val createdBy: String,
    val updatedAt: String,
    val updatedBy: String,
    val memo: String
)
