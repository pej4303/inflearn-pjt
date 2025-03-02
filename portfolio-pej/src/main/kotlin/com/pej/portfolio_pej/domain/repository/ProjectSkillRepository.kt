package com.pej.portfolio_pej.domain.repository

import com.pej.portfolio_pej.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime
import java.util.Optional

interface ProjectSkillRepository:JpaRepository<ProjectSkill, Long> {
    /**
     * select * from project_skill where project_id = :projectId and skill_id = :skillId
     */
    fun findByProjectIdAndSkillId(projectId: Long, skillId: Long): Optional<ProjectSkill>
}