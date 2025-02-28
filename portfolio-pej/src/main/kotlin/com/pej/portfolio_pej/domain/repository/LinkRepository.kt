package com.pej.portfolio_pej.domain.repository

import com.pej.portfolio_pej.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository:JpaRepository<Link, Long> {
}