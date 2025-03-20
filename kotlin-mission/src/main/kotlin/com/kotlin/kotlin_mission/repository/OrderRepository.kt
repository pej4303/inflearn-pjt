package com.kotlin.kotlin_mission.repository

import com.kotlin.kotlin_mission.domain.enity.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, Long>
