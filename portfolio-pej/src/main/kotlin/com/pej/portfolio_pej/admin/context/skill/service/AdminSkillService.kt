package com.pej.portfolio_pej.admin.context.skill.service

import com.pej.portfolio_pej.admin.data.TableDTO
import com.pej.portfolio_pej.domain.entity.Skill
import com.pej.portfolio_pej.domain.repository.SkillRepository
import org.springframework.stereotype.Service

@Service
class AdminSkillService (private val skillRepository: SkillRepository) {

    fun getSkillTable(): TableDTO {
        val classInfo = Skill::class
        val entities = skillRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}