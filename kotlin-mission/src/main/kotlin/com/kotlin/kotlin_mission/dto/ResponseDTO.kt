package com.kotlin.kotlin_mission.dto

data class ResponseDTO (
    val code: Int,
    val msg: String,
    val orderNo: Long?,
    val orderSts: String?
)