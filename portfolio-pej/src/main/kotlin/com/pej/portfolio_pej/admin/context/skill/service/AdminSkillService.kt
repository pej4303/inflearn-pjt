package com.pej.portfolio_pej.admin.context.skill.service

import com.pej.portfolio_pej.admin.context.skill.form.SkillForm
import com.pej.portfolio_pej.admin.data.TableDTO
import com.pej.portfolio_pej.admin.exception.AdminBadRequsetException
import com.pej.portfolio_pej.domain.constant.SkillType
import com.pej.portfolio_pej.domain.entity.Skill
import com.pej.portfolio_pej.domain.repository.SkillRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminSkillService (private val skillRepository: SkillRepository) {

    @Transactional
    fun getSkillTable(): TableDTO {
        val classInfo = Skill::class
        val entities = skillRepository.findAll()
        return TableDTO.from(classInfo, entities)
    }
    @Transactional
    fun save(form: SkillForm) {
        val skillType = SkillType.valueOf(form.type)
        skillRepository.findByNameIgnoreCaseAndType(form.name, skillType).ifPresent{ throw AdminBadRequsetException("중복된 데이터입니다.") }

        val item = form.toEntity()
        skillRepository.save(item)
    }
    @Transactional
    fun update(id:Long, form: SkillForm) {
        val item = form.toEntity(id)
        skillRepository.save(item)
    }
}