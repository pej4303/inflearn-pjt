package com.pej.portfolio_pej.presentation.dto

import com.pej.portfolio_pej.domain.entity.Project

class ProjectDTO(
    val name: String,
    val description: String,
    val startYearMonth: String,
    val endYearMonth: String?,
    val details: List<ProjectDetailDTO>,
    val skills: List<SkillDTO>?
) {
    constructor(project: Project) : this(
        name = project.name,
        description = project.description,
        startYearMonth = "${project.startYear}.${project.startMonth}", // 2023.9
        endYearMonth = project.getEndYearMonth(),
        details = project.details.map { detail -> ProjectDetailDTO(detail) },
        skills = project.skills.map { projectSkill -> SkillDTO(projectSkill.skill) }
    )
}
