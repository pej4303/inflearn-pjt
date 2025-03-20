package com.kotlin.kotlin_mission.domain.enity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdDateTime: LocalDateTime = LocalDateTime.now()

    @CreatedBy
    @Column(nullable = false, updatable = false)
    var createdBy: String = "system"

    @LastModifiedBy
    @Column(nullable = false)
    var updatedBy: String = "system"

    @LastModifiedDate
    @Column(nullable = false)
    var updateDateTime: LocalDateTime = LocalDateTime.now()
}
