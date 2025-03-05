package com.pej.portfolio_pej.presentation.dto

import com.pej.portfolio_pej.domain.entity.Link

class LinkDTO(
    val name: String,
    val content: String
) {
    constructor(link: Link): this(
        name = link.name.lowercase(),
        content = link.content
    )
}