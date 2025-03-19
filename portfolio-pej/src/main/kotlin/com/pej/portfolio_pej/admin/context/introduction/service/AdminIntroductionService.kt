package com.pej.portfolio_pej.admin.context.introduction.service

import com.pej.portfolio_pej.admin.data.TableDTO
import com.pej.portfolio_pej.domain.entity.Introduction
import com.pej.portfolio_pej.domain.repository.IntroductionRepository
import org.springframework.stereotype.Service

@Service
class AdminIntroductionService (private val introductionRepository: IntroductionRepository) {

    fun getIntroductionTable(): TableDTO {
        val classInfo = Introduction::class
        val entities = introductionRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}