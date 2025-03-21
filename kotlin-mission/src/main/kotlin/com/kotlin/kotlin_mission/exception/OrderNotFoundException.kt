package com.kotlin.kotlin_mission.exception

class OrderNotFoundException(val orderNo: Long) : RuntimeException("해당 주문정보가 없습니다. [주문번호 : $orderNo]")
