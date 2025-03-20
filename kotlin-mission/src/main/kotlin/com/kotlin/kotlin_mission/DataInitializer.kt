package com.kotlin.kotlin_mission


import com.kotlin.kotlin_mission.domain.enity.Product
import com.kotlin.kotlin_mission.repository.OrderDetailRepository
import com.kotlin.kotlin_mission.repository.OrderRepository
import com.kotlin.kotlin_mission.repository.ProductRepository
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
@Component
class DataInitializer(
    // val : final 변수
    private val orderRepository: OrderRepository,
    private val oderDetailRepository: OrderDetailRepository,
    private val productRepository: ProductRepository,
) {
    @PostConstruct
    fun initalizeData() {
        println("########### 데이터 초기화 ###########")

        // 상품 초기화
        var productList = mutableListOf<Product>(
            Product(
                productNm = "테스트상품1",
                productSts = "10",
                uom = "EA"
            ),
            Product(
                productNm = "테스트상품2",
                productSts = "10",
                uom = "EA"
            )
        )
         productRepository.saveAll(productList)
    }
}