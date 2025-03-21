package com.kotlin.kotlin_mission.service

import com.kotlin.kotlin_mission.constant.OrderSts
import com.kotlin.kotlin_mission.domain.enity.Order
import com.kotlin.kotlin_mission.domain.enity.OrderDetail
import com.kotlin.kotlin_mission.dto.OrderDetailDTO
import com.kotlin.kotlin_mission.dto.RequestDTO
import com.kotlin.kotlin_mission.dto.ResponseDTO
import com.kotlin.kotlin_mission.dto.ResponseListDTO
import com.kotlin.kotlin_mission.exception.ApiException
import com.kotlin.kotlin_mission.exception.OrderNotFoundException
import com.kotlin.kotlin_mission.exception.ProductNotFoundException
import com.kotlin.kotlin_mission.repository.OrderDetailRepository
import com.kotlin.kotlin_mission.repository.OrderRepository
import com.kotlin.kotlin_mission.repository.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService(private val orderRepository: OrderRepository, private val orderDetailRepository: OrderDetailRepository, private val productRepository: ProductRepository) {
    @Transactional(readOnly = true)
    fun select(orderNo: Long): ResponseEntity<ResponseListDTO<OrderDetailDTO>> {
        val orderDetail = orderDetailRepository.findByOrderNo(orderNo)

        val response = ResponseListDTO(
            items = listOf(OrderDetailDTO(orderNo = 1), OrderDetailDTO(orderNo = 1))
        )

        return ResponseEntity.status(HttpStatus.OK).body(response)
    }

    /**
     * 주문 생성
     */
    @Transactional
    fun create(requestDTO: RequestDTO): ResponseEntity<ResponseDTO> {
        // 주문 마스터 생성
        val orderHeader = Order(orderSts = "10")
        orderRepository.save(orderHeader)

        // 주문 상세 생성
        requestDTO.items.forEach { item ->
            val product = productRepository.findById(item.productCd).orElseThrow {
                ProductNotFoundException(item.productCd) // 상품 코드가 없을 경우 예외 던지기
            }
            val orderDetail = OrderDetail(
                order = orderHeader,
                product = product,
                price = item.price,
                qty = item.qty,
                memo = item.memo
            )
            orderDetailRepository.save(orderDetail)
        }

        val response = ResponseDTO(
            code = 200,
            msg = "주문 등록 성공",
            orderNo = orderHeader.orderNo,
            orderSts = orderHeader.orderSts
        )

        return ResponseEntity.status(HttpStatus.OK).body(response)
    }


    /**
     * 주문 수정
     */
    @Transactional
    fun update(orderNo: Long, requestDTO: RequestDTO): ResponseEntity<ResponseDTO> {
        // 주문 마스터
        val orderHeader = orderRepository.findById(orderNo).orElseThrow {
            OrderNotFoundException(orderNo) // 주문 정보가 없을 경우 예외 던지기
        }

        if ("60".equals(orderHeader.orderSts)) {
            val errorRes = ResponseDTO(
                code = 400,
                msg = "배송완료 상태는 수정 할 수 없습니다. [주문번호 : ${orderNo}]",
                orderNo = null,
                orderSts = null
            )

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRes)
        }

        // 주문 상세
        val orderDetail = orderDetailRepository.findByOrderNo(orderNo)

        requestDTO.items.forEach { item ->
            val product = productRepository.findById(item.productCd).orElseThrow {
                ProductNotFoundException(item.productCd) // 상품 코드가 없을 경우 예외 던지기
            }

            // 주문 상태가 유효한 코드인지 확인하고 적용
            val orderSts = OrderSts.values().find { it.code == item.orderSts } ?: throw ApiException("유효하지 않은 주문 상태 코드입니다. [주문상태 : ${item.orderSts}]")

            // 주문 마스터 업데이트
            orderHeader.orderSts = orderSts.code.toString() // code 값으로 업데이트
            orderRepository.save(orderHeader) // 주문 상태를 업데이트

            // 주문 상세 업데이트
            val updateOrderDetail = orderDetail.find { it.product == product }
            if (updateOrderDetail != null) {
                updateOrderDetail.price = item.price
                updateOrderDetail.qty = item.qty
                updateOrderDetail.memo = item.memo
                orderDetailRepository.save(updateOrderDetail) // 업데이트
            }
        }

        // 응답 반환
        val response = ResponseDTO(
            code = 200,
            msg = "주문 수정 성공",
            orderNo = orderNo,
            orderSts = orderHeader.orderSts
        )

        return ResponseEntity.status(HttpStatus.OK).body(response)
    }

    /**
     * 주문 삭제
     */
    @Transactional
    fun delete(orderNo: Long): ResponseEntity<ResponseDTO> {
        val orderHeader = orderRepository.findById(orderNo).orElseThrow {
            OrderNotFoundException(orderNo) // 주문 정보가 없을 경우 예외 던지기
        }

        val orderSts = orderHeader.orderSts
        if ("60".equals(orderSts)) {
            val errorRes = ResponseDTO(
                code = 400,
                msg = "배송완료 상태는 삭제 할 수 없습니다. [주문번호 : ${orderNo}]",
                orderNo = null,
                orderSts = null
            )

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRes)
        }

        orderDetailRepository.deleteByOrderNo(orderNo)
        orderRepository.deleteById(orderNo)

        val response = ResponseDTO(
            code = 200,
            msg = "주문 삭제 성공",
            orderNo = orderNo,
            orderSts = null
        )
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }
}
