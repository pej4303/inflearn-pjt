package com.pej.portfolio_pej.admin.context.experience.form

import com.pej.portfolio_pej.domain.entity.Achievement
import com.pej.portfolio_pej.domain.entity.Experience
import com.pej.portfolio_pej.domain.entity.ExperienceDetail
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import java.time.LocalDate

data class ExperienceDetailForm(
    val id: Long,
    @field:NotBlank(message = "필수값입니다.")
    val content: String,
    val isActive: Boolean
) {
    fun toEntity(): ExperienceDetail {
        return ExperienceDetail(
            content = this.content,
            isActive = this.isActive
            )
    }
}