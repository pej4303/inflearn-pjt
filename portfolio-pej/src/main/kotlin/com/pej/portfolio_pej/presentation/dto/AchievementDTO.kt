package com.pej.portfolio_pej.presentation.dto

/**
 * data class :
 *  - 데이터를 저장하는 용도로 설계된 클래스이다.
 *  - Spring Boot, Kotlin 기반 프로젝트에서 DTO로 자주 활용된다.
 *  - 속성으로 val가 권장되지만 var로 사용할 수도 있다.
 */
data class AchievementDTO (
    val title: String,
    val description: String,
    val host: String,
    val achievedDate: String?
)

