package com.pej.portfolio_pej.domain.entity

import jakarta.persistence.*

@Entity
class Experience(
          title: String
        , description: String
        , startYear: Int
        , startMonth: Int
        , endYear: Int?
        , endMonth: Int?
        , isActive: Boolean ) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    var id: Long? = null // null 허용

    var title: String = title

    var description: String = description

    var startYear: Int? = startYear

    var startMonth: Int? = startMonth

    var endYear: Int? = endYear

    var endMonth: Int? = endMonth

    var isActive: Boolean = isActive

    /**
     *  Experience는 ExperienceDetail과 1:N의 관계이다.
     *  @OneToMany : 1:N 관계를 설정해주는 것
     *     One => Experience
     *     Many => ExperienceDetail
     */
    @OneToMany(targetEntity = ExperienceDetail::class, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "experience_id")
    var details: MutableList<ExperienceDetail> = mutableListOf()

    fun getEndYearMonth(): String {
        if (endYear == null || endMonth == null) {
            return "Present"
        }

        return "${endYear}.${endMonth}"
    }

    /**
     * 필드 업데이트
     */
    fun update(title: String, description: String, startYear: Int, startMonth: Int, endYear: Int? , endMonth: Int? , isActive: Boolean) {
        this.title = title
        this.description = description
        this.startYear = startYear
        this.startMonth = startMonth
        this.endYear = endYear
        this.endMonth = endMonth
        this.isActive = isActive
    }

    fun addDetails(details: MutableList<ExperienceDetail>?) {
        if (details != null) {
            this.details.addAll(details)
        }
    }
}