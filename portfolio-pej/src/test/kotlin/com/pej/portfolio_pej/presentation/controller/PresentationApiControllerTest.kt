package com.pej.portfolio_pej.presentation.controller

import org.assertj.core.api.Assertions.assertThat
import org.json.JSONArray
import org.json.JSONObject
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

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
class PresentationApiControllerTest(
    @Autowired
    private val mockMvc: MockMvc
) {

    @Test
    @DisplayName("Introduction 조회")
    fun getIntroductions() {
        // given
        val url = "/api/v1/introductions"

        // when: API 요청을 보냄
        val result = mockMvc.perform(MockMvcRequestBuilders.get(url))
            .andExpect(status().isOk)  // 응답 상태 코드가 200 OK인지 확인
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))  // 응답 타입이 JSON인지 확인
            .andReturn()  // 결과 반환

        // 응답 본문을 문자열로 추출
        val content = result.response.contentAsString

        // 응답을 JSONArray로 파싱
        val jsonArray = JSONArray(content)

        // then: 검증
        assertThat(jsonArray.length()).isPositive()  // 응답 배열의 길이가 양수인지 확인
    }


    @Test
    @DisplayName("Link 조회")
    fun getLinks() {
        // given
        val url = "/api/v1/links"

        // when: API 요청을 보냄
        val result = mockMvc.perform(MockMvcRequestBuilders.get(url))
            .andExpect(status().isOk)  // 응답 상태 코드가 200 OK인지 확인
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))  // 응답 타입이 JSON인지 확인
            .andReturn()  // 결과 반환

        // 응답 본문을 문자열로 추출
        val content = result.response.contentAsString

        // 응답을 JSONArray로 파싱
        val jsonArray = JSONArray(content)

        // then: 검증
        assertThat(jsonArray.length()).isPositive()  // 응답 배열의 길이가 양수인지 확인
    }

    @Test
    @DisplayName("Project 조회")
    fun getProjects() {
        // given
        val url = "/api/v1/projects"

        // when: API 요청을 보냄
        val result = mockMvc.perform(MockMvcRequestBuilders.get(url))
            .andExpect(status().isOk)  // 응답 상태 코드가 200 OK인지 확인
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))  // 응답 타입이 JSON인지 확인
            .andReturn()  // 결과 반환

        // 응답 본문을 문자열로 추출
        val content = result.response.contentAsString

        // 응답을 JSONArray로 파싱
        val jsonArray = JSONArray(content)

        // then: 검증
        assertThat(jsonArray.length()).isPositive()  // 응답 배열의 길이가 양수인지 확인
    }

    @Test
    @DisplayName("Resume 조회")
    fun getResume() {
        // given
        val url = "/api/v1/resume"

        // when: API 요청을 보냄
        val result = mockMvc.perform(MockMvcRequestBuilders.get(url))
            .andExpect(status().isOk)  // 응답 상태 코드가 200 OK인지 확인
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))  // 응답 타입이 JSON인지 확인
            .andReturn()  // 결과 반환

        // 응답 본문을 문자열로 추출
        val content = result.response.contentAsString

        // 응답을 JSONObject로 파싱
        val jsonObject = JSONObject(content)

        // then: 검증
        assertThat(jsonObject.optJSONArray("experiences").length()).isPositive()
        assertThat(jsonObject.optJSONArray("achievements").length()).isPositive()
        assertThat(jsonObject.optJSONArray("skills").length()).isPositive()
    }
}