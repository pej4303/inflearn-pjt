package com.kotlin.kotlin_mission.constant

enum class OrderSts(val code:Int, val codeNm: String) {
    PAYMENT_COMPLETED(10, "결제완료"),
    PRODUCT_PREPARING(20, "상품준비중"),
    SHIPPED(50, "배송중"),
    DELIVERED(60, "배송완료");

    /**
     * companion object : Kotlin은 static을 사용하지 않고 대신 companion object를 사용한다.
     */
    companion object {
        // 코드값으로 enum 값 찾기
        fun getCode(code: Int): Int {
            return values().find { it.code == code }?.code ?: throw Exception("없는 주문상태 입니다. [$code]")
        }
    }
}

