package com.pej.portfolio_pej.admin.context.skill.service

import com.pej.portfolio_pej.admin.context.link.form.LinkForm
import com.pej.portfolio_pej.admin.context.skill.form.SkillForm
import com.pej.portfolio_pej.admin.data.TableDTO
import com.pej.portfolio_pej.admin.exception.AdminBadRequsetException
import com.pej.portfolio_pej.domain.constant.SkillType
import com.pej.portfolio_pej.domain.repository.ProjectRepository
import com.pej.portfolio_pej.domain.repository.ProjectSkillRepository
import com.pej.portfolio_pej.domain.repository.SkillRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminProjectSkillService (private val skillRepository: SkillRepository, private val projectRepository: ProjectRepository, private val projectSkillRepository: ProjectSkillRepository) {

    @Transactional
    fun getProjectSkillTable(): TableDTO {
        val projects = projectRepository.findAll()
        val columns = mutableListOf<String>("id", "projectId", "projectName", "skillId", "skillName", "createdDateTime", "updatedDateTime")
        val recordList = mutableListOf<MutableList<String>>()
        for (project in projects) {
            project.skills.forEach {
                val record = mutableListOf<String>()
                record.add(it.id.toString())
                record.add(it.project.id.toString())
                record.add(it.project.name)
                record.add(it.skill.id.toString())
                record.add(it.skill.name)
                record.add(it.createdDateTime.toString())
                record.add(it.updateDateTime.toString())
                recordList.add(record)
            }
        }

        return TableDTO(name = "ProjectSkill", columns = columns, records = recordList)
    }
    fun getProjectList(): List<String> {
        val projects = projectRepository.findAll()
        return projects.map { "${it.id} (${it.name})" }.toList()
    }
    fun getSkillList(): List<String> {
        val skills = skillRepository.findAll()
        return skills.map { "${it.id} (${it.name})" }.toList()
    }
}