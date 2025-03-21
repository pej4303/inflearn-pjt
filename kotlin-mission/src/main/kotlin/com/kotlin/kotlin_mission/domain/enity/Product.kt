package com.kotlin.kotlin_mission.domain.enity

import jakarta.persistence.*

@Entity
@Table(name = "TB_PRODUCT")
class Product(
    productNm: String,
    uom: String
): BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID 자동 생성 전략
    var productCd: Long? = null  // 상품ID

    @Column(name = "product_nm", length = 255)
    var productNm: String = productNm  // 상품명

    @Column(name = "uom", length = 10)
    var uom: String = uom  // 상품 단위
}