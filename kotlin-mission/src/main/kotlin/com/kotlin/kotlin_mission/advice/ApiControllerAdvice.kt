package com.kotlin.kotlin_mission.advice

import com.kotlin.kotlin_mission.dto.ResponseDTO
import com.kotlin.kotlin_mission.exception.ApiException
import com.kotlin.kotlin_mission.exception.OrderNotFoundException
import com.kotlin.kotlin_mission.exception.ProductNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * @RestControllerAdvice:
 *   - Spring에서 전역 예외 처리를 담당하는 어노테이션이다.
 */
@RestControllerAdvice
class ApiControllerAdvice {
    /**
     * 없는 상품인 경우
     */
    @ExceptionHandler(ProductNotFoundException::class)
    fun handleProductNotFoundException(ex: ProductNotFoundException): ResponseEntity<ResponseDTO> {
        val errorRes= ResponseDTO(
            code = 400,
            msg = "${ex.message}",
            orderNo = null,
            orderSts = null
        )
        return ResponseEntity.badRequest().body(errorRes)
    }

    /**
     * 유효성 검사
     * MethodArgumentNotValidException : @Valid 어노테이션을 사용하여 유효성 검사 실패 시 발생하는 예외
     */
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleException(ex: MethodArgumentNotValidException): ResponseEntity<ResponseDTO> {
        ex.printStackTrace() // 예외를 콘솔에 출력하여 흐름을 확인
        // 유효성 검사 오류 메시지를 추출하여 하나의 문자열로 결합
        val errorMsgList = ex.bindingResult.allErrors.map { it.defaultMessage }
        val errorMsg = errorMsgList.joinToString(", ") // 여러 개의 메시지를 하나로 합침

        // 오류 메시지를 포함한 ResponseDTO 생성
        val errorRes = ResponseDTO(
            code = 400,
            msg = errorMsg,
            orderNo = null,
            orderSts = null
        )

        // BAD_REQUEST(400) 상태 코드와 함께 응답 반환
        return ResponseEntity.badRequest().body(errorRes)
    }

    @ExceptionHandler(ApiException::class)
    fun handleException(ex: ApiException): ResponseEntity<ResponseDTO> {
        // 오류 메시지를 포함한 ResponseDTO 생성
        val errorRes = ResponseDTO(
            code = 400,
            msg = "${ex.message}",
            orderNo = null,
            orderSts = null
        )

        // BAD_REQUEST(400) 상태 코드와 함께 응답 반환
        return ResponseEntity.badRequest().body(errorRes)
    }

    @ExceptionHandler(OrderNotFoundException::class)
    fun handleException(ex: OrderNotFoundException): ResponseEntity<ResponseDTO> {
        // 오류 메시지를 포함한 ResponseDTO 생성
        val errorRes = ResponseDTO(
            code = 400,
            msg = "${ex.message}",
            orderNo = null,
            orderSts = null
        )

        // BAD_REQUEST(400) 상태 코드와 함께 응답 반환
        return ResponseEntity.badRequest().body(errorRes)
    }

}