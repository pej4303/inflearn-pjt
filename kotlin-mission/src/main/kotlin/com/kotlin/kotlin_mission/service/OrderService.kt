package com.kotlin.kotlin_mission.service

import com.kotlin.kotlin_mission.domain.enity.Order
import com.kotlin.kotlin_mission.domain.enity.OrderDetail
import com.kotlin.kotlin_mission.dto.RequestDTO
import com.kotlin.kotlin_mission.dto.ResponseDTO
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
    fun getOrderById(orderId: Long): Order {
        return orderRepository
                .findById(orderId)
                .orElseThrow {
                    NoSuchElementException("주문을 찾을 수 없습니다. 주문 번호: $orderId")
                }
    }

    fun getAllOrders(): List<Order> {
        return orderRepository.findAll()
    }

    /**
     * 주문 생성
     */
    @Transactional
    fun create(requestDTO: RequestDTO):  ResponseEntity<ResponseDTO> {
        // 주문 엔티티 생성
        val orderHeader = Order(orderSts = "10")
        orderRepository.save(orderHeader)

        // 주문 항목 처리
        requestDTO.items.forEach {
            item ->
                val product = productRepository.findById(item.productCd).orElseThrow { RuntimeException("해당 상품코드가 없습니다.: ${item.productCd}") }
                val orderDetail = OrderDetail(
                    order = orderHeader,
                    product = product,
                    price = item.price,
                    qty = item.qty,
                    memo = item.memo
                )
                orderDetailRepository.save(orderDetail)
        }

        var response = ResponseDTO(
            code = 200,
            msg = "주문 등록 성공",
            orderNo = orderHeader.orderNo,
            orderSts = orderHeader.orderSts // 기본적으로 "10"으로 설정 (필요에 따라 변경)
        )

        return ResponseEntity.status(HttpStatus.OK).body(response)
    }

    /**
     * 주문 수정
     */
    @Transactional
    fun update(orderNo: Long, requestDTO: RequestDTO): ResponseEntity<ResponseDTO> {
        // 주문 조회
        val orderHeader = orderRepository.findById(orderNo).orElseThrow { RuntimeException("주문이 존재하지 않습니다.: ${orderNo}") }
        val orderDetail = orderDetailRepository.findByOrderNo(orderNo)

        requestDTO.items.forEach { item ->
            val product = productRepository.findById(item.productCd).orElseThrow { RuntimeException("해당 상품코드가 없습니다.: ${item.productCd}") }

            val updateOrderDetail = orderDetail.find { it.product == product }

            if (updateOrderDetail != null) {
                // 기존 주문 상세가 있으면 업데이트
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
            orderNo = orderHeader.orderNo,
            orderSts = orderHeader.orderSts
        )

        return ResponseEntity.status(HttpStatus.OK).body(response)
    }

    /**
     * 주문 삭제
     */
    @Transactional
    fun delete(orderNo: Long): ResponseEntity<ResponseDTO> {
        orderDetailRepository.deleteByOrderNo(orderNo)
        orderRepository.deleteById(orderNo)

        val response = ResponseDTO(
            code = 200,
            msg = "주문 삭제 성공",
            orderNo = orderNo,
            orderSts = ""
        )
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }
}
