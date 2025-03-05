package com.pej.portfolio_pej.presentation.dto

import com.pej.portfolio_pej.domain.entity.Introduction

data class IntroductionDTO (
    val content: String
) {
    /**
     * 생성자를 오버라이딩 한다.
     */
    constructor(introduction: Introduction): this(
        // 파라미터로 받은 Introduction의 content를 넣어준다.
        content = introduction.content
    )
}