package com.kotlin.kotlin_mission.repository

import com.kotlin.kotlin_mission.domain.enity.OrderDetail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

interface OrderDetailRepository: JpaRepository<OrderDetail, Long> {
    @Query("SELECT o FROM OrderDetail o WHERE o.order.orderNo = :orderNo")
    fun findByOrderNo(@Param("orderNo") orderNo: Long): List<OrderDetail>

    @Modifying
    @Transactional
    @Query("DELETE FROM OrderDetail o WHERE o.order.orderNo = :orderNo")
    fun deleteByOrderNo(@Param("orderNo") orderNo: Long)
}