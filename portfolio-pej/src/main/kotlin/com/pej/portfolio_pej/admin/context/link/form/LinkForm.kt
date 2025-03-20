package com.pej.portfolio_pej.admin.context.link.form

import com.pej.portfolio_pej.domain.entity.Link
import jakarta.validation.constraints.NotBlank

data class LinkForm(
    @field:NotBlank(message = "필수값입니다.")
    val name: String,
    @field:NotBlank(message = "필수값입니다.")
    val content: String,
    val isActive: Boolean
) {
    fun toEntity(): Link {
        return Link(
            name = this.name,
            content = this.content,
            isActive = this.isActive
        )
    }
    fun toEntity(id: Long): Link {
        val item = this.toEntity();
        item.id = id

        return item
    }
}