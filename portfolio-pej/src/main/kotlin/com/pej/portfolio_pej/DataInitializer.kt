package com.pej.portfolio_pej

import com.pej.portfolio_pej.domain.constant.SkillType
import com.pej.portfolio_pej.domain.entity.*
import com.pej.portfolio_pej.domain.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

/**
 * @Component : 해당 클래스가 Spring의 빈(Bean)으로 등록되도록 지정하는 역할을 합니다.
 *
 * Spring Boot에서는 자동 스캔이 활성화되어 있어 별도 설정 없이도 빈으로 등록된다.
 * 하지만 특정 패키지만 스캔하고 싶다면 @Component을 명시적으로 사용할 수 있다.
 */
@Component
@Profile(value = ["default"])  // "default" 프로파일이 활성화될 때만 빈 등록한다.
class DataInitializer(
      // val : final 변수
      private val achievementRepository: AchievementRepository
    , private val introductionRepository: IntroductionRepository
    , private val linkRepository: LinkRepository
    , private val skillRepository: SkillRepository
    , private val projectRepository: ProjectRepository
    , private val experienceRepository: ExperienceRepository
) {

    /**
     * @PostConstruct :
     *  - 빈이 생성되고 의존성 주입이 완료된 후 실행할 초기화 메서드를 지정하는 데 사용한다.
     *  - 애플리케이션 실행 시 해당 빈이 초기화될 때 한 번만 실행된다.
     *  - 데이터 로드, 캐시 초기화, 설정 값 검증 등에 주로 사용된다.
     */
    @PostConstruct
    fun initalizeData() {
        /**
         * mutableListOf():
         *  - Kotlin에서 변경 가능한 리스트(MutableList)를 생성하는 함수이다.
         *  - ArrayList를 기반으로 한 가변 리스트(MutableList<T>) 를 생성한다.
         */
        println("########### 데이터 초기화 ###########")

        // achievement 초기화
      val achievements = mutableListOf<Achievement>(
          Achievement(
              title = "SQL개발자(SQLD)",
              description = "데이터베이스",
              host = "한국데이터베이스진흥센터",
              achievedDate = LocalDate.of(2022, 4, 1),
              isActive = true
          ),
          Achievement(
              title = "정보처리기사",
              description = "자료구조, 운영체제, 알고리즘, 데이터베이스 등",
              host = "한국산업인력공단",
              achievedDate = LocalDate.of(2018, 5, 1),
              isActive = true
          ),
          Achievement(
              title = "정보처리산업기사",
              description = "자료구조, 운영체제, 알고리즘, 데이터베이스 등",
              host = "한국산업인력공단",
              achievedDate = LocalDate.of(2014, 8, 1),
              isActive = true
          ),
      )
      achievementRepository.saveAll(achievements)
      
      // introduction 초기화
      val introductions = mutableListOf<Introduction>(
          Introduction(content = "꾸준함이 무기인 개발자입니다.", isActive = true),
          Introduction(content = "다양한 프로젝트를 경험했고 특히 레거시한 프로젝트에 익숙합니다.", isActive = true),
          Introduction(content = "변화하는 기술 환경에 대응하기 위해 정기적으로 스터디 모임을 진행하고 있습니다.", isActive = true)
      )
      introductionRepository.saveAll(introductions)
      
      // link 초기화
      val links = mutableListOf<Link>(
          Link(name = "Github", content = "https://github.com/pej4303", isActive = true),
          Link(name = "Github", content = "https://github.com/ISFX-Study",isActive = true),
      )
      linkRepository.saveAll(links)
      
      // experience / experience_detail 초기화
      val experience1 = Experience(
          title = "한양여자대학교",
          description = "컴퓨터정보과",
          startYear = 2012,
          startMonth = 3,
          endYear = 2015,
          endMonth = 3,
          isActive = true,
      )
      experience1.addDetails(
          mutableListOf(
              ExperienceDetail(content = "", isActive = true)
          )
      )
      val experience2 = Experience(
          title = "한양사이버대학교",
          description = "컴퓨터공학과",
          startYear = 2015,
          startMonth = 9,
          endYear = 2017,
          endMonth = 8,
          isActive = true,
      )
      experience2.addDetails(
          mutableListOf(
              ExperienceDetail(content = "", isActive = true)
          )
      )
      val experience3 = Experience(
          title = "(주)이루다컴",
          description = "Biz2팀",
          startYear = 2016,
          startMonth = 5,
          endYear = 2024,
          endMonth = 9,
          isActive = true,
      )
      experience3.addDetails(
          mutableListOf(
              ExperienceDetail(content = "MRO솔루션 및 SI 프로젝트 개발", isActive = true),
              ExperienceDetail(content = "2020년도 최우수사원상 수상", isActive = true)
          )
      )
      experienceRepository.saveAll(mutableListOf(experience1, experience2, experience3))
      
      // skill 초기화
      val java = Skill(name = "Java", type = SkillType.LANGUAGE.name, isActive = true)
      val spring = Skill(name = "Spring", type = SkillType.FRAMEWORK.name, isActive = true)
      val oracle = Skill(name = "Oracle", type = SkillType.DATABASE.name, isActive = true)
      val tibero = Skill(name = "Tibero", type = SkillType.DATABASE.name, isActive = true)

      skillRepository.saveAll(mutableListOf(java, spring, oracle, tibero))
      
      // project / project_detail / project_skill 초기화
      val project1 = Project(
          name = "대한통운 TCS 운영",
          description = "대한통운 TCS 운영",
          startYear = 2025,
          startMonth = 2,
          endYear = null,
          endMonth = null,
          isActive = true
      )
      project1.addDetails(
          mutableListOf(
              ProjectDetail(content = "Single Visibility 신규 고객사 기능 개발", url = null, isActive = true),
              ProjectDetail(content = "FTP 인터페이스 개선 작업(Python -> Java)", url = null, isActive = true)
          )
      )
      project1.skills.addAll(
          mutableListOf(
              ProjectSkill(project = project1, skill = java),
              ProjectSkill(project = project1, skill = spring),
              ProjectSkill(project = project1, skill = oracle)
          )
      )
      val project2 = Project(
          name = "큐로직 GPO 구매시스템 구축",
          description = "큐로직 GPO 구매시스템",
          startYear = 2023,
          startMonth = 5,
          endYear = 2023,
          endMonth = 8,
          isActive = true
      )
      project2.addDetails(
          mutableListOf(
              ProjectDetail(content = "관리자 주문 조회, 수정 및 반품 기능을 구현", url = null, isActive = true),
              ProjectDetail(content = "빌게이트 PG사를 이용하여 결제 처리 및 취소 기능을 구현", url = null, isActive = true),
              ProjectDetail(content = "EAI 및 RestAPI를 활용하여 유형별 주문 등록 인터페이스, 주문 반품 인터페이스 구현", url = null, isActive = true),
              ProjectDetail(content = "Quartz를 이용하여 배치 구현", url = null, isActive = true)
          )
      )
      project2.skills.addAll(
          mutableListOf(
              ProjectSkill(project = project2, skill = java),
              ProjectSkill(project = project2, skill = spring),
              ProjectSkill(project = project2, skill = tibero)
          )
      )
      projectRepository.saveAll(mutableListOf(project1, project2))

    }
}
