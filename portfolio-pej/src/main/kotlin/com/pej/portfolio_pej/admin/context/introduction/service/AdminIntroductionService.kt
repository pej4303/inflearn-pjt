package com.pej.portfolio_pej.admin.context.introduction.service

import com.pej.portfolio_pej.admin.context.introduction.form.IntroductionForm
import com.pej.portfolio_pej.admin.data.TableDTO
import com.pej.portfolio_pej.domain.entity.Introduction
import com.pej.portfolio_pej.domain.repository.IntroductionRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class AdminIntroductionService (private val introductionRepository: IntroductionRepository) {

    fun getIntroductionTable(): TableDTO {
        val classInfo = Introduction::class
        val entities = introductionRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
    @Transactional
    fun save(form: IntroductionForm) {
        val item = form.toEntity()
        introductionRepository.save(item)
    }
    @Transactional
    fun update(id:Long, form: IntroductionForm) {
        val item = form.toEntity(id)
        introductionRepository.save(item)
    }
}