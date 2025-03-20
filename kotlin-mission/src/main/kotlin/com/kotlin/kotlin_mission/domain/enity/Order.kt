package com.kotlin.kotlin_mission.domain.enity

import jakarta.persistence.*

@Entity
@Table(name = "TB_ORDER")
class Order(orderSts: String): BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_no")
    var orderNo: Long? = null

    @Column(name = "order_sts", length = 10)
    var orderSts: String = orderSts // 주문상태

    // 1:N 관계 설정 (Order는 여러 OrderDetail을 가질 수 있음)
//    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL], orphanRemoval = true)
    var orderDetails: MutableList<OrderDetail> = mutableListOf()
}
