package com.kotlin.kotlin_mission.domain.enity

import jakarta.persistence.*

@Entity
@Table(name = "TB_CODE")
class Code: BaseEntity() {
    @Id
    @Column(name = "cd", length = 10)
    var cd: String? = null // 코드

    @Column(name = "cd_nm", length = 255)
    var cdNm: String = "" // 코드명

    @Column(name = "desc", length = 255)
    var desc: String = "" // 설명

    @Column(name = "detail_cd", length = 10)
    var detailCd: String = "" // 상세코드

    @Column(name = "detail_cd_nm", length = 255)
    var detailCdNm: String = "" // 상세코드명

    @Column(name = "order_no")
    var orderNo: Int? = null  // 정렬순번
}