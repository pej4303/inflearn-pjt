package com.pej.portfolio_pej.domain.repository

import com.pej.portfolio_pej.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository:JpaRepository<Skill, Long> {
}