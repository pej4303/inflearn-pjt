package com.kotlin.kotlin_mission.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.kotlin.kotlin_mission.constant.OrderSts
import com.kotlin.kotlin_mission.domain.enity.Order
import com.kotlin.kotlin_mission.domain.enity.OrderDetail
import com.kotlin.kotlin_mission.domain.enity.Product
import com.kotlin.kotlin_mission.dto.OrderDTO
import com.kotlin.kotlin_mission.dto.RequestDTO
import com.kotlin.kotlin_mission.repository.OrderDetailRepository
import com.kotlin.kotlin_mission.repository.OrderRepository
import com.kotlin.kotlin_mission.repository.ProductRepository
import org.assertj.core.api.Assertions
import org.json.JSONArray
import org.json.JSONObject
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 *  @SpringBootTest :
 *   - 서버를 띄워서 테스트를 할때 사용하는 어노테이션이다.
 *   - 전체 애플리케이션의 통합 테스트에 사용된다.
 *  @AutoConfigureMockMvc :
 *   - MockMvc를 자동으로 설정하는 어노테이션이다.
 *   - Spring MVC를 모의로 테스트할때 사용된다.
 */
@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest
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
        val orderHeader = Order(orderSts = "10")
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
        ).andReturn()  // 결과 반환

        // 응답 본문을 문자열로 추출
        val content = result.response.contentAsString
        println("DDDDDDDDDD")
        println(content)
        println("DDDDDDDDDD")

        // 응답 파싱
        val response = JSONArray(content)
        println("응답 = " + response)

        /**
         * then: 검증
         */
//        Assertions.assertThat(response.length()).isOdd()
    }


    @Test
    @DisplayName("주문 등록 API - 정상")
    fun postOrderCase1() {
        /**
         * given : url 호출 및 요청 DTO 생성
         */
        val url = "/api/order"

        /**
         * {
         *   "items": [
         *     {
         *       "productCd": 10000,
         *       "price": 10000,
         *       "qty": 1,
         *       "memo": "테스트주문1"
         *     },
         *     {
         *       "productCd": 10001,
         *       "price": 10000,
         *       "qty": 1,
         *       "memo": "테스트주문2"
         *     }
         *   ]
         * }
         */
        val request = RequestDTO(
            items = listOf(
                OrderDTO(productCd = 1, price = 10000, qty = 1, memo = "테스트 주문1", orderSts = null),
                OrderDTO(productCd = 2, price = 10000, qty = 1, memo = "테스트 주문2", orderSts = null)
            )
        )

        /**
         * when: API 요청을 보냄
         */
        val result = mockMvc.perform(
            MockMvcRequestBuilders.post(url)                        // POST 요청을 생성
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
        Assertions.assertThat(response.get("msg")).isEqualTo("주문 등록 성공")
    }

    @Test
    @DisplayName("주문 등록 API - 미등록상품코드인 경우")
    fun postOrderCase2() {
        /**
         * given : url 호출 및 요청 DTO 생성
         */
        val url = "/api/order"
        val request = RequestDTO(
            items = listOf(
                OrderDTO(productCd = 11111, price = 10000, qty = 1, memo = "없는상품코드", orderSts = null)
            )
        )

        /**
         * when: API 요청을 보냄
         */
        val result = mockMvc.perform(
            MockMvcRequestBuilders.post(url)                        // POST 요청을 생성
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
    @DisplayName("주문 등록 API - 가격이 없는 경우")
    fun postOrderCase3() {
        /**
         * given : url 호출 및 요청 DTO 생성
         */
        val url = "/api/order"
        val request = RequestDTO(
            items = listOf(
                OrderDTO(productCd = 1, price = 0, qty = 1, memo = "가격이 없음", orderSts = null)
            )
        )

        /**
         * when: API 요청을 보냄
         */
        val result = mockMvc.perform(
            MockMvcRequestBuilders.post(url)                        // POST 요청을 생성
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
    @DisplayName("주문 수정 API - 정상")
    fun putOrderCase1() {
        /**
         * given : url 호출 및 요청 DTO 생성
         */
        val url = "/api/order/1"
        val request = RequestDTO(
            items = listOf(
                OrderDTO(productCd = 1, price = 10000, qty = 1, memo = "주문 상태 변경", orderSts = 60)
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
        Assertions.assertThat(response.get("code")).isEqualTo(200)
    }

    @Test
    @DisplayName("주문 수정 API - 미등록 주문상태인 경우")
    fun putOrderCase2() {
        /**
         * given : url 호출 및 요청 DTO 생성
         */
        val url = "/api/order/1"
        val request = RequestDTO(
            items = listOf(
                OrderDTO(productCd = 1, price = 10000, qty = 1, memo = "주문 상태 변경", orderSts = 100)
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
        val request = RequestDTO(
            items = listOf(
                OrderDTO(productCd = 1, price = 10000, qty = 1, memo = "주문 상태 변경", orderSts = 30)
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
    @DisplayName("주문 삭제 API - 없는 주문번호인 경우")
    fun deleteOrderCase2() {
        /**
         * given : url 호출 및 요청 DTO 생성
         */
        val url = "/api/order/10000"

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