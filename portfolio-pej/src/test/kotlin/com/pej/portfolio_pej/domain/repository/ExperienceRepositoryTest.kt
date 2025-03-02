package com.pej.portfolio_pej.domain.repository

import com.pej.portfolio_pej.domain.entity.Experience
import com.pej.portfolio_pej.domain.entity.ExperienceDetail
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.time.LocalDate


/**
 * @DataJpaTest : JPA 관련 빈만 로드하여 테스트 할 수 있게 만들어 준다.
 *
 * @TestInstance(TestInstance.Lifecycle.PER_CLASS):
 *   - 클래스당 하나의 테스트 인스턴스만 생성되도록 설정한다. 즉 테스트 클래스의 모든 테스트 메소드가 하나의 인스턴스에서 실행된다.
 *   - @BeforeAll, @AfterAll 같은 메소드를 인스턴스 메소드로 선언할 수 있고 객체 상태를 테스트 간에 공유할 수 있게 해준다.
 */
@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExperienceRepositoryTest(
    @Autowired
    val experienceRepository: ExperienceRepository
) {
    val DATA_SIZE = 10

    private fun createExperience(n: Int): Experience {

        var experience = Experience(
              title = "${n}"
            , description = "테스트 실행 ${n}"
            , startYear = LocalDate.now().year
            , startMonth = LocalDate.now().month.value
            , endYear = LocalDate.now().year
            , endMonth = 12
            , isActive = true
        )

        var details = mutableListOf<ExperienceDetail>()
        for (i in 1..n) {
            var experienceDetail = ExperienceDetail(content = "테스트 ${i}", isActive = true)
            details.add(experienceDetail)
        }

        experience.addDetails(details)

        return experience
    }

    @BeforeAll
    fun beforeClear() {
        println("########## 데이터 초기화 이전 조회 시작 ##########")
        var beforeInitialize = experienceRepository.findAll()
        assertThat(beforeInitialize).hasSize(0)
        println("########## 데이터 초기화 이전 조회 종료 ##########")

        println("########## 데이터 초기화 시작 ##########")
        var experienceList = mutableListOf<Experience>()
        for (i in 1..DATA_SIZE) {
            val experience = createExperience(i)
            experienceList.add(experience)
        }
        experienceRepository.saveAll(experienceList)
        println("########## 데이터 초기화 종료 ##########")
    }

    @Test
    fun testFindAll() {
        /**
         * N+1 문제가 발생함
         *  => experience 테이블에서 한번 조회하고 해당하는 상세 내역 조회까지 총 11번 쿼리가 발생함
         */
        println("########## testFindAll 시작 ##########")

        var experienceList = experienceRepository.findAll()
        assertThat(experienceList).hasSize(DATA_SIZE)
        println("experienceList.size = ${experienceList.size}")

        for (item in experienceList) {
            assertThat(item.details).hasSize(item.title.toInt())
            println("details.size = ${item.details.size}")
        }

        println("########## testFindAll 종료 ##########")
    }

    @Test
    fun testFindAllByIsActive() {
        println("########## findAllByIsActive 테스트 시작##########")
        val experiences = experienceRepository.findAllByIsActive(true)
        assertThat(experiences).hasSize(DATA_SIZE)
        println("experiences.size: ${experiences.size}")
        for (experience in experiences) {
            assertThat(experience.details).hasSize(experience.title.toInt())
            println("experience.details.size: ${experience.details.size}")
        }
        println("##########  findAllByIsActive 테스트 종료 ##########")
    }
}