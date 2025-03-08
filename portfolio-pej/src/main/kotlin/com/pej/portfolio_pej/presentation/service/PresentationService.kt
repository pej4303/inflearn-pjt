package com.pej.portfolio_pej.presentation.service

import com.pej.portfolio_pej.presentation.dto.IntroductionDTO
import com.pej.portfolio_pej.presentation.dto.LinkDTO
import com.pej.portfolio_pej.presentation.dto.ProjectDTO
import com.pej.portfolio_pej.presentation.dto.ResumeDTO
import com.pej.portfolio_pej.presentation.repository.PresentationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PresentationService(
    private val presentationRepository: PresentationRepository
) {

    /**
     * @Transactional :
     *  - 트랜잭션을 간편하게 열고 닫을 수 있게 해줍니다.
     *  - readOnly : JPA 사용시 더티체킹 등을 수행하지 않게 때문에 성능상 이점이 있다.
     *  - rollbackFor : 예외 발생시 어떻게 롤백할지 정의한다.
     */
    @Transactional(readOnly = true)
    fun getIntroductions(): List<IntroductionDTO> {
        val introductions = presentationRepository.getActiveIntroductions()
        // IntroductionDTO 생성자로 매핑해줘서 return
        return introductions.map { item -> IntroductionDTO(item) }
   }
    @Transactional(readOnly = true)
    fun getLinks(): List<LinkDTO> {
        val links = presentationRepository.getActiveLinks()
        return links.map { item -> LinkDTO(item) }
    }

    @Transactional(readOnly = true)
    fun getProjects(): List<ProjectDTO> {
        val project = presentationRepository.getActiveProjects()
        return project.map { item -> ProjectDTO(item) }
    }
    @Transactional(readOnly = true)
    fun getResume(): ResumeDTO {
        val experiences = presentationRepository.getActiveExperiences()
        val achievements = presentationRepository.getActiveAchievements()
        val skills = presentationRepository.getActiveSkills()

        return ResumeDTO(
            experiences = experiences,
            achievements = achievements,
            skills = skills
        )
    }
}