package com.pej.portfolio_pej.domain.repository

import com.pej.portfolio_pej.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectSkillRepository:JpaRepository<ProjectSkill, Long> {
}