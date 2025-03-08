package com.pej.portfolio_pej.presentation.service

import com.pej.portfolio_pej.domain.entity.Introduction
import com.pej.portfolio_pej.domain.entity.Link
import com.pej.portfolio_pej.presentation.repository.PresentationRepository
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

/**
 * @ExtendWith(MockitoExtension::class) :
 *   - JUnit5에서 Mockito를 사용하기 위한 확장(Extension) 을 의미한다.
 * Mockito :
 *   - 가짜 객체를 만드는 도구
 */
@ExtendWith(MockitoExtension::class)
class PresentationServiceTest {

    /**
     * @InjectMocks :
     *   - Mock 객체를 테스트 대상 객체에 주입한다.
     * lateinit :
     *   - Kotlin에서 변수의 초기화를 지연시킨다.
     */
    @InjectMocks
    lateinit var presentationService: PresentationService
    /**
     * @Mock :
     *   - Mock 객체를 생성한다.
     */
    @Mock
    lateinit var presentationRepository: PresentationRepository

    val DATA_SIZE = 9

    @Test
    fun getIntroductions() {
        /**
         * given : 조건 설정
         */
        val list = mutableListOf<Introduction>()

        // DATA_SIZE 만큼 반복하면서 isActive는 i가 짝수일 경우 true 홀수일 경우 false로 설정한다.
        for (i in 1..DATA_SIZE) {
            val introduction = Introduction(content = "${i}", isActive = i%2 == 0)
            list.add(introduction)
        }

        /**
         * when : 동작 설정 및 실행
         */
        // isActive가 true인 항목들만 필터링하여 activeList를 만든다.
        val activeList = list.filter { item -> item.isActive }

        // presentationRepository.getActiveIntroductions()가 호출되었을 때 반환할 값으로 설정한다.
        // when이 코틀린에서 예약어여서 `when`이 된거
        Mockito.`when`(presentationRepository.getActiveIntroductions())
            .thenReturn(activeList)

        // 실제로 테스트할 대상인 presentationService.getIntroductions() 메서드를 호출하고 그 결과를 introductionDTO에 저장한다.
        val introductionDTO = presentationService.getIntroductions()

        /**
         * then : 결과 검증
         */
        // introductionDTO의 크기가 DATA_SIZE / 2인지 확인한다.
        assertThat(introductionDTO).hasSize(DATA_SIZE / 2)
        // 각 introduction의 content 값이 짝수인지 확인한다.
        // content는 문자열이지만 이를 toInt()로 변환하여 짝수인지 검증한다.
        for (introduction in introductionDTO) {
            assertThat(introduction.content.toInt()).isEven()
        }
    }

    @Test
    fun getLinks() {
        /**
         * given : 조건 설정
         */
        val list = mutableListOf<Link>()

        for (i in 1..DATA_SIZE) {
            val introduction = Link(name = "${i}", content = "${i}", isActive = i % 2 != 0)
            list.add(introduction)
        }

        /**
         * when : 동작 설정 및 실행
         */
        val activeList = list.filter { item -> item.isActive }

        Mockito.`when`(presentationRepository.getActiveLinks())
            .thenReturn(activeList)

        val linkDTO = presentationService.getLinks()

        /**
         * then : 결과 검증
         */
        for (link in linkDTO) {
            assertThat(link.content.toInt()).isOdd()
        }
    }

    @Test
    fun getProjects() {
    }

    @Test
    fun getResume() {
    }
}