package com.pej.portfolio_pej.admin.context.project.form

import com.pej.portfolio_pej.admin.context.experience.form.ExperienceDetailForm
import com.pej.portfolio_pej.domain.entity.Link
import com.pej.portfolio_pej.domain.entity.Project
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive

data class ProjectSkillForm(
    @field:NotBlank(message = "필수값입니다.")
    val project: String,
    @field:NotBlank(message = "필수값입니다.")
    val skill: String
)