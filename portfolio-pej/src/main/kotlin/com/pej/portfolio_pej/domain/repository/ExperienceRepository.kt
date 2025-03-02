package com.pej.portfolio_pej.domain.repository

import com.pej.portfolio_pej.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.time.LocalDateTime
import java.util.*

interface ExperienceRepository:JpaRepository<Experience, Long> {
    fun countAllByCreatedDateTimeBetween(start: LocalDateTime, end: LocalDateTime)

    /**
     * N+1 문제가 발생하여 소스를 변경함
     *  => experience 테이블에서 한번 조회하고 해당하는 상세 내역 조회까지 총 11번 쿼리가 발생함
     */
    @Query("select e from Experience e join fetch e.details where e.isActive = :isActive")
    fun findAllByIsActive(isActive: Boolean): List<Experience>
    @Query("select e from Experience e join fetch e.details where e.id = :id")
    override fun findById(id: Long): Optional<Experience>
}