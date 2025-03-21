package com.kotlin.kotlin_mission.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.kotlin.kotlin_mission.dto.OrderDTO
import com.kotlin.kotlin_mission.dto.RequestDTO
import org.assertj.core.api.Assertions
import org.json.JSONArray
import org.json.JSONObject
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.platform.commons.logging.Logger
import org.junit.platform.commons.logging.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

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
    @Test
    @DisplayName("주문 등록 API - 테스트케이스1")
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
                OrderDTO(productCd = 1, price = 10000, qty = 1, memo = "테스트 주문1"),
                OrderDTO(productCd = 2, price = 10000, qty = 1, memo = "테스트 주문2")
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

        println(response)

        /**
         * then: 검증
         */
        Assertions.assertThat(response.get("msg")).isEqualTo("주문 등록 성공")
    }

    @Test
    @DisplayName("주문 등록 API - 테스트케이스2")
    fun postOrderCase2() {
        /**
         * given : url 호출 및 요청 DTO 생성
         */
        val url = "/api/order"
        val request = RequestDTO(
            items = listOf(
                OrderDTO(productCd = 11111, price = 10000, qty = 1, memo = "없는상품코드")
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
        println(response)

        /**
         * then: 검증
         */
        Assertions.assertThat(response.get("code")).isEqualTo(400)
    }

    @Test
    @DisplayName("주문 등록 API - 테스트케이스3")
    fun postOrderCase3() {
        /**
         * given : url 호출 및 요청 DTO 생성
         */
        val url = "/api/order"
        val request = RequestDTO(
            items = listOf(
                OrderDTO(productCd = 1, price = 0, qty = 1, memo = "가격이 없음")
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
        println(response)

        /**
         * then: 검증
         */
        Assertions.assertThat(response.get("code")).isEqualTo(400)
    }
}