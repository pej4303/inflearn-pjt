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
class OrderSelectTest
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
    @DisplayName("주문 조회 API - 정상")
    fun getOrderCase1() {
        /**
         * given : url 호출 및 요청 DTO 생성
         */
        val url = "/api/order/1"


        /**
         * when: API 요청을 보냄
         */
        val result = mockMvc.perform(
            MockMvcRequestBuilders.get(url)                        // GET 요청을 생성
                .contentType(MediaType.APPLICATION_JSON)            // 주로 JSON 형식의 데이터를 서버로 보내거나 받을 때 사용함
        ).andReturn()  // 결과 반환

        // 응답 상태 코드 출력
        println("응답 상태 코드 = ${result.response.status}")

        // 응답 본문을 문자열로 추출
        val content = result.response.contentAsString
        println("응답 본문 = $content")

//        // 응답 파싱
//        val response = JSONObject(content)
//        println("응답 = " + response)
//
//        /**
//         * then: 검증
//         */
//        Assertions.assertThat(response.get("code")).isEqualTo(200)
    }

    @Test
    @DisplayName("주문 수정 API - 없는 주문상태인 경우")
    fun putOrderCase2() {
        /**
         * given : url 호출 및 요청 DTO 생성
         */
        val url = "/api/order/1"
        val request = RequestUpdateDTO(
            orderSts = 100,
            items = listOf(
                OrderDTO(productCd = 1, price = 10000, qty = 1, memo = "주문 상태 변경")
            )
        )

        /**
         * when: API 요청을 보냄
         */
        val result = mockMvc.perform(
            MockMvcRequestBuilders.put(url)                        // PUT 요청을 생성
                .content(objectMapper.writeValueAsString(request))  // 본문에 JSON 데이터 포함
                .contentType(MediaType.APPLICATION_JSON)            // 주로 JSON 형식의 데이터를 서버로 보내거나 받을 때 사용함
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
    @DisplayName("주문 수정 API - 배송완료건인 경우")
    fun putOrderCase3() {
        /**
         * given : url 호출 및 요청 DTO 생성
         */
        val url = "/api/order/1"
        val request = RequestUpdateDTO(
            orderSts = OrderSts.DELIVERED.code,
            items = listOf(
                OrderDTO(productCd = 1, price = 10000, qty = 1, memo = "주문 상태 변경")
            )
        )

        /**
         * when: API 요청을 보냄
         */
        val result = mockMvc.perform(
            MockMvcRequestBuilders.put(url)                        // PUT 요청을 생성
                .content(objectMapper.writeValueAsString(request))  // 본문에 JSON 데이터 포함
                .contentType(MediaType.APPLICATION_JSON)            // 주로 JSON 형식의 데이터를 서버로 보내거나 받을 때 사용함
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