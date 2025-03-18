package com.pej.portfolio_pej.admin.exception

import org.springframework.http.HttpStatus

abstract class AdminException(
    httpStatus: HttpStatus,  // HTTP 상태 코드
    message: String,          // 예외 메시지
) : RuntimeException(message) {  // RuntimeException(message) 상속
    val httpStatus: HttpStatus = httpStatus  // httpStatus 필드 선언 및 초기화


}

/**
 * 사용자 정의 Exception
 */
class AdminBadRequsetException(message: String): AdminException(
    httpStatus = HttpStatus.BAD_REQUEST,
    message = message
)
class AdminInternalServiceErrorException(message: String): AdminException(
    httpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
    message = message
)