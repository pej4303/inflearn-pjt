package com.kotlin.kotlin_mission.repository

import com.kotlin.kotlin_mission.domain.enity.Order
import com.kotlin.kotlin_mission.domain.enity.OrderDetail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, Long> {

}