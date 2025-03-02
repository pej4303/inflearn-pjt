package com.pej.portfolio_pej.domain.repository


import com.pej.portfolio_pej.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository


interface AchievementRepository:JpaRepository<Achievement, Long> {
    /**
     * Q. 반환 타입으로 List를 사용하는 이유
     * A. MutableList를 반환 타입으로 사용할 수 있지만
     *    Spring Data JPA의 반환 타입으로는 일반적으로 List가 더 적합하고 변수를 수정할 필요가 없는 경우에는 불변 컬렉션을 사용하는 것이 권장된다.
     */
    /**
     * select * from achievement where is_active = :isActive
     */
    fun findAllByIsActive(isActive: Boolean): List<Achievement>
}