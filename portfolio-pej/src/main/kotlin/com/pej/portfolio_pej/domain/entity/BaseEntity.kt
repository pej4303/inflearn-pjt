package com.pej.portfolio_pej.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

//  @MappedSuperclass : 여러 엔티티의 공통 컬럼을 갖고 있는 상위 클래스에 사용한다.
@MappedSuperclass
abstract class BaseEntity {
    /**
     *  @CreatedDate : 생성된 시간을 자동으로 저장할 때 사용한다.
     *  @LastModifiedDate : 수정된 시간을 자동으로 저장할 때 사용한다.
     */
    @CreatedDate
    @Column(nullable = false, updatable = false)
    /**
     * createdDateTime 라는 변수에 LocalDateTime 타입으로 선언하면서 초기값으로 LocalDateTime.now()를 설정한다.
     */
    var createdDateTime: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    @Column(nullable = false)
    var updateDateTime: LocalDateTime = LocalDateTime.now()
}