package com.pej.portfolio_pej.admin.context.project.service

import com.pej.portfolio_pej.admin.data.TableDTO
import com.pej.portfolio_pej.admin.exception.AdminBadRequsetException
import com.pej.portfolio_pej.domain.entity.Project
import com.pej.portfolio_pej.domain.entity.ProjectDetail
import com.pej.portfolio_pej.domain.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class AdminProjectService(private val projectRepository: ProjectRepository) {
    fun getProjectTable(): TableDTO {
        val classInfo = Project::class
        val entities = projectRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
    fun getProjectDetailTable(id: Long?): TableDTO {
        val classInfo = ProjectDetail::class
        val entities = if (id != null) {
            projectRepository.findById(id).orElseThrow{ throw AdminBadRequsetException("ID ${id}에 해당하는 데이터를 찾을 수 없습니다.") }.details
        } else {
            emptyList()
        }


        return TableDTO.from(classInfo, entities)
    }
}