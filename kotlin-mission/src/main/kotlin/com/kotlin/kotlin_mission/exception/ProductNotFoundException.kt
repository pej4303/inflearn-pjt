package com.kotlin.kotlin_mission.exception

class ProductNotFoundException(val productCd: Long) : RuntimeException("해당 상품코드가 없습니다. [상품코드 : $productCd]")
