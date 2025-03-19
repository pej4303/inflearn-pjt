package com.pej.portfolio_pej.admin.context.experience.service

import com.pej.portfolio_pej.admin.data.TableDTO
import com.pej.portfolio_pej.admin.exception.AdminBadRequsetException
import com.pej.portfolio_pej.domain.entity.Experience
import com.pej.portfolio_pej.domain.entity.ExperienceDetail
import com.pej.portfolio_pej.domain.repository.ExperienceRepository
import org.springframework.stereotype.Service

@Service
class AdminExperienceService(private val experienceRepository: ExperienceRepository) {
    fun getExperienceTable(): TableDTO {
        val classInfo = Experience::class
        val entities = experienceRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
    fun getExperienceDetailTable(id: Long?): TableDTO {
        val classInfo = ExperienceDetail::class
        val entities = if (id != null) {
            experienceRepository.findById(id).orElseThrow{ throw AdminBadRequsetException("ID ${id}에 해당하는 데이터를 찾을 수 없습니다.") }.details
        } else {
            emptyList()
        }


        return TableDTO.from(classInfo, entities)
    }
}