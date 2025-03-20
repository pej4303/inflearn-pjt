package com.kotlin.kotlin_mission.repository

import com.kotlin.kotlin_mission.domain.enity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long> {
}