package com.pej.portfolio_pej.admin.context.project.form

import com.pej.portfolio_pej.domain.entity.Achievement
import com.pej.portfolio_pej.domain.entity.Experience
import com.pej.portfolio_pej.domain.entity.ExperienceDetail
import com.pej.portfolio_pej.domain.entity.ProjectDetail
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import java.time.LocalDate

data class ProjectDetailForm(
    val id: Long,
    @field:NotBlank(message = "필수값입니다.")
    val content: String,
    val url: String?,
    val isActive: Boolean
) {
    fun toEntity(): ProjectDetail {
        return ProjectDetail(
            content = this.content,
            url = this.url,
            isActive = this.isActive
        )
    }
}