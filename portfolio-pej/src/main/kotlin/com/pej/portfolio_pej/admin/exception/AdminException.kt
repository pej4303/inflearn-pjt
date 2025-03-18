package com.pej.portfolio_pej.admin.exception

import org.springframework.http.HttpStatus

class AdminException(
    httpStatus: HttpStatus,  // HTTP 상태 코드
    message: String,          // 예외 메시지
) : RuntimeException(message) {  // RuntimeException(message) 상속
    val httpStatus: HttpStatus = httpStatus  // httpStatus 필드 선언 및 초기화
}
