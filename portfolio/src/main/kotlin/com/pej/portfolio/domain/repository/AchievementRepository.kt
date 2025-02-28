package com.pej.portfolio.domain.repository

import com.pej.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository


interface AchievementRepository:JpaRepository<Achievement, Long> {
}