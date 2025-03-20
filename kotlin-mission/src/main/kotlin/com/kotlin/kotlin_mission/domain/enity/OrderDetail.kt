package com.kotlin.kotlin_mission.domain.enity

import jakarta.persistence.*

@Entity
@Table(name = "TB_ORDER_DETAIL")
class OrderDetail(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_no", referencedColumnName = "order_no", nullable = false)
    var order: Order,  // 반드시 생성자에서 초기화

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_cd", nullable = false)
    var product: Product,  // 반드시 생성자에서 초기화

    @Column(name = "price")
    var price: Int,

    @Column(name = "qty")
    var qty: Int,

    @Column(name = "vat")
    var vat: Int = 0,

    @Column(name = "total_price")
    var totalPrice: Int = 0,

    @Column(name = "memo")
    var memo: String?
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_line_no")
    var orderLineNo: Long? = null  // 주문 라인번호 자동 생성

    /**
     * 총금액 자동 계산
     */
    @PrePersist
    @PreUpdate
    fun calculateTotalPrice() {
        vat = price / 10
        totalPrice = (qty * price) + vat
    }
}