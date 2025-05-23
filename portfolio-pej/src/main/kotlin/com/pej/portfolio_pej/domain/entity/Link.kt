package com.pej.portfolio_pej.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Link(
          name: String
        , content: String
        , isActive: Boolean) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "link_id")
    var id: Long? = null // null 허용

    var name: String = name

    var content: String = content

    var isActive: Boolean = isActive
}