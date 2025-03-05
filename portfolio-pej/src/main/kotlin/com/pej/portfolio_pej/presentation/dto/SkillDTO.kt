package com.pej.portfolio_pej.presentation.dto

import com.pej.portfolio_pej.domain.entity.Skill

data class SkillDTO (
    val name: String,
    val type: String
) {
    constructor(skill: Skill): this(
        name = skill.name,
        type = skill.type.name
    )
}