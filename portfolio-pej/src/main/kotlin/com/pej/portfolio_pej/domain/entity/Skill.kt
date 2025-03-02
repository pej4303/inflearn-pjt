package com.pej.portfolio_pej.domain.entity

import com.pej.portfolio_pej.domain.constant.SkillType
import jakarta.persistence.*

@Entity
class Skill(
          name: String
        , type: String
        , isActive: Boolean) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    var id: Long? = null // null 허용

    var name: String = name

    /**
     * @Enumerated : 자료형이 Enum 타입일 때 컬럼에 값을 매핑할지 정한다.
     * EnumType.STRING : Enum의 이름을 문자열로 저장한다. (데이터를 직관적으로 파악하기 쉽게 하기 위해서 STRING으로 해주는 것이 좋다.)
     */
    @Column(name = "skill_type")
    @Enumerated(value = EnumType.STRING)
    var type: SkillType = SkillType.valueOf(type)

    var isActive: Boolean = isActive
}