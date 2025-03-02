package com.pej.portfolio_pej.domain.repository

import com.pej.portfolio_pej.domain.entity.Achievement
import com.pej.portfolio_pej.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository:JpaRepository<Introduction, Long> {
    /**
     * select * from introduction where is_active = :isActive
     */
    fun findAllByIsActive(isActive: Boolean): List<Introduction>
}