package com.pej.portfolio_pej.domain.repository

import com.pej.portfolio_pej.domain.constant.SkillType
import com.pej.portfolio_pej.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SkillRepository:JpaRepository<Skill, Long> {
    /**
     * select * from skill where is_active = :isActive
     */
    fun findAllByIsActive(isActive: Boolean): List<Skill>

    /**
     * select * from skill where lower(name) = lower(:name) and skill_type = :type
     */
    fun findByNameIgnoreCaseAndType(name: String, type: SkillType): Optional<Skill>

}