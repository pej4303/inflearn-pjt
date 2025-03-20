package com.pej.portfolio_pej.admin.context.project.controller

import com.pej.portfolio_pej.admin.context.achivement.form.AchievementForm
import com.pej.portfolio_pej.admin.context.achivement.service.AdminAchievementService
import com.pej.portfolio_pej.admin.context.experience.form.ExperienceForm
import com.pej.portfolio_pej.admin.context.experience.service.AdminExperienceService
import com.pej.portfolio_pej.admin.context.project.form.ProjectForm
import com.pej.portfolio_pej.admin.context.project.service.AdminProjectService
import com.pej.portfolio_pej.admin.data.*
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/api/project")
class AdminProjectApiController(private val adminProjectService: AdminProjectService) {
    @PostMapping
    fun postExperience(@RequestBody @Validated form: ProjectForm): ResponseEntity<Any> {
        adminProjectService.save(form)
        return ApiRespone.successCreate()
    }
    @PutMapping("/{id}")
    fun putExperience(@PathVariable id:Long, @RequestBody form: ProjectForm): ResponseEntity<Any> {
        adminProjectService.update(id, form)
        return ApiRespone.successUpdate()
    }
    @GetMapping("/{id}/detail")
    fun getExperienceDetail(@PathVariable id:Long): TableDTO {
        return adminProjectService.getProjectDetailTable(id)
    }
}