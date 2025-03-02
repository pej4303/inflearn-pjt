package com.pej.portfolio_pej.domain.repository

import com.pej.portfolio_pej.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface ExperienceRepository:JpaRepository<Experience, Long> {
    fun countAllByCreatedDateTimeBetween(start: LocalDateTime, end: LocalDateTime)
}