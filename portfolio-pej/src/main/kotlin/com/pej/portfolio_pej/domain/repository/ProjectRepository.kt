package com.pej.portfolio_pej.domain.repository

import com.pej.portfolio_pej.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository:JpaRepository<Project, Long> {
}