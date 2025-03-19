package com.pej.portfolio_pej.admin.context.achivement.service

import com.pej.portfolio_pej.admin.data.TableDTO
import com.pej.portfolio_pej.domain.entity.Achievement
import com.pej.portfolio_pej.domain.repository.AchievementRepository
import org.springframework.stereotype.Service

@Service
class AdminAchievementService(private val achievementRepository: AchievementRepository) {

    fun getAchievementTable(): TableDTO {
        val classInfo = Achievement::class
        val entities = achievementRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}