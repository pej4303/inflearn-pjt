package com.kotlin.kotlin_mission.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.kotlin.kotlin_mission.constant.OrderSts
import com.kotlin.kotlin_mission.domain.enity.Order
import com.kotlin.kotlin_mission.domain.enity.OrderDetail
import com.kotlin.kotlin_mission.domain.enity.Product
import com.kotlin.kotlin_mission.dto.OrderDTO
import com.kotlin.kotlin_mission.dto.RequestUpdateDTO
import com.kotlin.kotlin_mission.repository.OrderDetailRepository
import com.kotlin.kotlin_mission.repository.OrderRepository
import com.kotlin.kotlin_mission.repository.ProductRepository
import org.assertj.core.api.Assertions
import org.json.JSONObject
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.transaction.annotation.Transactional


@SpringBootTest
@AutoConfigureMockMvc
class OrderDeleteTest
    @Autowired constructor(
    private val mockMvc: MockMvc,
    private val objectMapper: ObjectMapper
) {

    @Autowired
    lateinit var orderRepository: OrderRepository
    @Autowired
    lateinit var productRepository: ProductRepository
    @Autowired
    lateinit var orderDetailRepository: OrderDetailRepository

    @BeforeEach
    @Transactional
    fun initOrder() {
        // 테스트 실행 전에 초기 주문 데이터를 삽입
        val orderHeader = Order(orderSts = OrderSts.PAYMENT_COMPLETED.code)
        orderRepository.save(orderHeader)

        var product = productRepository.findById(1).orElse(null)
        if (product == null) {
            product = Product(productNm = "초기상품", uom = "EA")
        }

        val orderDetail = OrderDetail(
            order = orderHeader,
            product = product,
            price = 10000,
            qty = 1,
            memo = "초기데이터"
        )
        orderDetailRepository.save(orderDetail)

        println("주문 초기 데이터 완료")
    }

    @Test
    @DisplayName("주문 삭제 API - 정상")
    fun deleteOrderCase1() {
        /**
         * given : url 호출 및 요청 DTO 생성
         */
        val url = "/api/order/1"


        /**
         * when: API 요청을 보냄
         */
        val result = mockMvc.perform(
            MockMvcRequestBuilders.delete(url)                        // DELETE 요청을 생성
        ).andReturn()  // 결과 반환

        // 응답 본문을 문자열로 추출
        val content = result.response.contentAsString

        // 응답 파싱
        val response = JSONObject(content)
        println("응답 = " + response)

        /**
         * then: 검증
         */
        Assertions.assertThat(response.get("code")).isEqualTo(200)
    }

    @Test
    @DisplayName("주문 삭제 API - 없는 주문상태인 경우")
    fun deleteOrderCase2() {
        /**
         * given : url 호출 및 요청 DTO 생성
         */
        val url = "/api/order/1000"

        /**
         * when: API 요청을 보냄
         */
        val result = mockMvc.perform(
            MockMvcRequestBuilders.delete(url)                        // DELETE 요청을 생성
        ).andReturn()  // 결과 반환

        // 응답 본문을 문자열로 추출
        val content = result.response.contentAsString

        // 응답 파싱
        val response = JSONObject(content)
        println("응답 = " + response)

        /**
         * then: 검증
         */
        Assertions.assertThat(response.get("code")).isEqualTo(400)
    }

    @Test
    @DisplayName("주문 삭제 API - 배송완료건인 경우")
    fun deleteOrderCase3() {
        /**
         * given : url 호출 및 요청 DTO 생성
         */
        val url = "/api/order/1"

        /**
         * when: API 요청을 보냄
         */
        val result = mockMvc.perform(
            MockMvcRequestBuilders.delete(url)                        // DELETE 요청을 생성
        ).andReturn()  // 결과 반환

        // 응답 본문을 문자열로 추출
        val content = result.response.contentAsString

        // 응답 파싱
        val response = JSONObject(content)
        println("응답 = " + response)

        /**
         * then: 검증
         */
        Assertions.assertThat(response.get("code")).isEqualTo(400)
    }

}