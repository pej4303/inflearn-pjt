package com.kotlin.kotlin_mission.domain.enity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "TB_ORDER")
class Order(orderSts: Int): BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_no")
    var orderNo: Long? = null

    @Column(name = "order_sts", length = 10)
    var orderSts: Int = orderSts // 주문상태

    @Column(name = "delYn", length = 10)
    var delYn: String = "N"        // 삭제구분

    @Column(name = "orderDate")
    var orderDate: LocalDateTime = LocalDateTime.now()  // 주문일자

    // 1:N 관계 설정 (Order는 여러 OrderDetail을 가질 수 있음)
//    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL], orphanRemoval = true)
    var orderDetails: MutableList<OrderDetail> = mutableListOf()
}
