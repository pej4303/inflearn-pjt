package com.pej.portfolio_pej.domain.repository

import com.pej.portfolio_pej.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository

interface HttpInterfaceRepository:JpaRepository<HttpInterface, Long> {
}