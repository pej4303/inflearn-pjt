package com.pej.portfolio_pej.admin.context.achivement.service

import com.pej.portfolio_pej.admin.context.achivement.form.AchievementForm
import com.pej.portfolio_pej.admin.data.TableDTO
import com.pej.portfolio_pej.domain.entity.Achievement
import com.pej.portfolio_pej.domain.repository.AchievementRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class AdminAchievementService(private val achievementRepository: AchievementRepository) {

    fun getAchievementTable(): TableDTO {
        val classInfo = Achievement::class
        val entities = achievementRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    @Transactional
    fun save(form: AchievementForm) {
        val item = form.toEntity()
        achievementRepository.save(item)
    }
    @Transactional
    fun update(id:Long, form:AchievementForm) {
        val item = form.toEntity(id)
        achievementRepository.save(item)
    }
}