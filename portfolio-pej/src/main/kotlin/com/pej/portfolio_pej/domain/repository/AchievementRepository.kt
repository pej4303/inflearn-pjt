package com.pej.portfolio_pej.domain.repository


import com.pej.portfolio_pej.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository


interface AchievementRepository:JpaRepository<Achievement, Long> {
}