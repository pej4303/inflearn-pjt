package com.pej.portfolio_pej.domain.repository

import com.pej.portfolio_pej.domain.entity.Achievement
import com.pej.portfolio_pej.domain.entity.Experience
import com.pej.portfolio_pej.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface ProjectRepository:JpaRepository<Project, Long> {
    /**
     * select * from project where is_active = :isActive
     */
    @Query("  select p " +
            "  from Project p " +
            "  left join fetch p.skills s " +
            "  left join fetch s.skill " +
            " where p.isActive = :isActive")
    fun findAllByIsActive(isActive: Boolean): List<Project>

    /**
     * Q. 이미 있는데 재정의(override) 하는 이유?
     * A. 성능이 안 좋아서
     */
    @Query("select p from Project p join fetch p.details where p.id = :id")
    override fun findById(id: Long): Optional<Project>
}