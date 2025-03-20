package com.kotlin.kotlin_mission.dto

data class OrderDTO(
    val productCd: Long,
    val price: Int,
    val qty: Int,
    val memo: String
)