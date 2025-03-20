package com.pej.portfolio_pej.admin.context.introduction.form

import com.pej.portfolio_pej.domain.entity.Achievement
import com.pej.portfolio_pej.domain.entity.Introduction
import jakarta.validation.constraints.NotBlank

data class IntroductionForm(
    @field:NotBlank(message = "필수값입니다.")
    val content: String,
    val isActive: Boolean
) {
    fun toEntity(): Introduction {
        return Introduction(
            content = this.content,
            isActive = this.isActive
        )
    }
    fun toEntity(id: Long): Introduction {
        val item = this.toEntity();
        item.id = id

        return item
    }
}