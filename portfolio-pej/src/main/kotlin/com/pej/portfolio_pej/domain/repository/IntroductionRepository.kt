package com.pej.portfolio_pej.domain.repository

import com.pej.portfolio_pej.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository:JpaRepository<Introduction, Long> {
}