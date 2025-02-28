package com.pej.portfolio_pej.domain.repository

import com.pej.portfolio_pej.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository:JpaRepository<Experience, Long> {
}