package com.pej.portfolio_pej.admin.context.skill.form

import com.pej.portfolio_pej.domain.entity.Skill
import jakarta.validation.constraints.NotBlank

data class SkillForm(
    @field:NotBlank(message = "필수값입니다.")
    val name: String,
    @field:NotBlank(message = "필수값입니다.")
    val type: String,
    val isActive: Boolean
) {
    fun toEntity(): Skill {
        return Skill(
            name = this.name,
            type = this.type,
            isActive = this.isActive
        )
    }
    fun toEntity(id: Long): Skill {
        val item = this.toEntity();
        item.id = id

        return item
    }
}