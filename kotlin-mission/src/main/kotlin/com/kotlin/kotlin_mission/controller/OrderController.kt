package com.kotlin.kotlin_mission.controller

import com.kotlin.kotlin_mission.domain.enity.Order
import com.kotlin.kotlin_mission.domain.enity.OrderDetail
import com.kotlin.kotlin_mission.dto.RequestDTO
import com.kotlin.kotlin_mission.dto.ResponseDTO
import com.kotlin.kotlin_mission.service.OrderService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/order")
class OrderController(private val orderService: OrderService) {
    /**
     * 주문 조회
     */
    @GetMapping("/{orderNo}")
    fun getOrderById(@PathVariable orderNo: Long): List<OrderDetail> {
        return orderService.select(orderNo)
    }

    /**
     * 주문 등록
     */
    @PostMapping
    fun postOrder(@Valid  @RequestBody requestDTO: RequestDTO): ResponseEntity<ResponseDTO> {
        return orderService.create(requestDTO)
    }

    /**
     * 주문 수정
     */
    @PutMapping("/{orderNo}")
    fun putOrder(@PathVariable orderNo: Long, @RequestBody requestDTO: RequestDTO): ResponseEntity<ResponseDTO> {
        return orderService.update(orderNo, requestDTO)
    }

    /**
     * 주문 삭제
     */
    @DeleteMapping("/{orderNo}")
    fun deleteOrder(@PathVariable orderNo: Long): ResponseEntity<ResponseDTO> {
        return orderService.delete(orderNo)
    }
}
