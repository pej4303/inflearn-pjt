package com.pej.portfolio_pej.domain.repository

import com.pej.portfolio_pej.domain.entity.Introduction
import com.pej.portfolio_pej.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository:JpaRepository<Link, Long> {
    /**
     * select * from link where is_active = :isActive
     */
    fun findAllByIsActive(isActive: Boolean): List<Link>
}