package com.pej.portfolio_pej.presentation.repository

import com.pej.portfolio_pej.domain.entity.*
import com.pej.portfolio_pej.domain.repository.*
import org.springframework.stereotype.Repository

@Repository
class PresentationRepository(
      private val achievementRepository: AchievementRepository
    , private val introductionRepository: IntroductionRepository
    , private val linkRepository: LinkRepository
    , private val skillRepository: SkillRepository
    , private val projectRepository: ProjectRepository
    , private val experienceRepository: ExperienceRepository
) {
    /**
     * 프레젠테이션 레이어에 필요한 기능들을 PresentationRepository에서 관리하기 위해서 만들어졌음
     */
    fun getActiveAchievements(): List<Achievement> {
        return achievementRepository.findAllByIsActive(true)
    }
    fun getActiveIntroduction(): List<Introduction> {
        return introductionRepository.findAllByIsActive(true)
    }
    fun getActiveLink(): List<Link> {
        return linkRepository.findAllByIsActive(true)
    }
    fun getActiveSkill(): List<Skill> {
        return skillRepository.findAllByIsActive(true)
    }
    fun getActiveProject(): List<Project> {
        return projectRepository.findAllByIsActive(true)
    }
    fun getActiveExperience(): List<Experience> {
        return experienceRepository.findAllByIsActive(true)
    }
}